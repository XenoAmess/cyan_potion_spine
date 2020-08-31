/******************************************************************************
 * Spine Runtimes License Agreement
 * Last updated January 1, 2020. Replaces all prior versions.
 *
 * Copyright (c) 2013-2020, Esoteric Software LLC
 *
 * Integration of the Spine Runtimes into software or otherwise creating
 * derivative works of the Spine Runtimes is permitted under the terms and
 * conditions of Section 2 of the Spine Editor License Agreement:
 * http://esotericsoftware.com/spine-editor-license
 *
 * Otherwise, it is permitted to integrate the Spine Runtimes into software
 * or otherwise create derivative works of the Spine Runtimes (collectively,
 * "Products"), provided that each user of the Products must obtain their own
 * Spine Editor license and redistribution of the Products in any form must
 * include this license and copyright notice.
 *
 * THE SPINE RUNTIMES ARE PROVIDED BY ESOTERIC SOFTWARE LLC "AS IS" AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL ESOTERIC SOFTWARE LLC BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES,
 * BUSINESS INTERRUPTION, OR LOSS OF USE, DATA, OR PROFITS) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THE SPINE RUNTIMES, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *****************************************************************************/

package com.esotericsoftware.spine.attachments;

import com.esotericsoftware.spine.Bone;
import org.joml.Vector2f;
import org.joml.Vector4f;
import static com.esotericsoftware.spine.utils.SpineUtils.cosDeg;
import static com.esotericsoftware.spine.utils.SpineUtils.radDeg;
import static com.esotericsoftware.spine.utils.SpineUtils.sinDeg;

/** An attachment which is a single point and a rotation. This can be used to spawn projectiles, particles, etc. A
 * bone can be
 * used in similar ways, but a PointAttachment is slightly less expensive to compute and can be hidden, shown, and
 * placed in a
 * skin.
 * <p>
 * See <a href="http://esotericsoftware.com/spine-point-attachments">Point Attachments</a> in the Spine User Guide. */
public class PointAttachment extends Attachment {
    float x, y, rotation;

    // Nonessential.
    final Vector4f color = new Vector4f(0.9451f, 0.9451f, 0, 1); // f1f100ff

    public PointAttachment(String name) {
        super(name);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getRotation() {
        return rotation;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    /** The color of the point attachment as it was in Spine. Available only when nonessential data was exported.
     * Point attachments
     * are not usually rendered at runtime. */
    public Vector4f getColor() {
        return color;
    }

    public Vector2f computeWorldPosition(Bone bone, Vector2f point) {
        point.x = x * bone.getA() + y * bone.getB() + bone.getWorldX();
        point.y = x * bone.getC() + y * bone.getD() + bone.getWorldY();
        return point;
    }

    public float computeWorldRotation(Bone bone) {
        float cos = cosDeg(rotation), sin = sinDeg(rotation);
        float x = cos * bone.getA() + sin * bone.getB();
        float y = cos * bone.getC() + sin * bone.getD();
        return (float) Math.atan2(y, x) * radDeg;
    }

    @Override
    public Attachment copy() {
        PointAttachment copy = new PointAttachment(name);
        copy.x = x;
        copy.y = y;
        copy.rotation = rotation;
        copy.color.set(color);
        return copy;
    }
}
