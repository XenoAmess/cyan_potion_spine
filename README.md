# spine-cyan_potion

Notice:
This is NOT completed yet! I'm working with it now, so DON'T look at this repo for now. Will be added to cyan_potion when complete.

Notice:
this is modified from spine-libgdx at [spine-libgdx](https://github.com/EsotericSoftware/spine-runtimes/tree/3.8/spine-libgdx)


The spine-cyan_potion runtime provides functionality to load, manipulate and render [Spine](http://esotericsoftware.com) skeletal animation data using [cyan_potion](https://github.com/cyanpotion/cyan_potion).

## Licensing

You are welcome to evaluate the Spine Runtimes and the examples we provide in this repository free of charge.

You can integrate the Spine Runtimes into your software free of charge, but users of your software must have their own [Spine license](https://esotericsoftware.com/spine-purchase). Please make your users aware of this requirement! This option is often chosen by those making development tools, such as an SDK, game toolkit, or software library.

In order to distribute your software containing the Spine Runtimes to others that don't have a Spine license, you need a [Spine license](https://esotericsoftware.com/spine-purchase) at the time of integration. Then you can distribute your software containing the Spine Runtimes however you like, provided others don't modify it or use it to create new software. If others want to do that, they'll need their own Spine license.

For the official legal terms governing the Spine Runtimes, please read the [Spine Runtimes License Agreement](http://esotericsoftware.com/spine-runtimes-license) and Section 2 of the [Spine Editor License Agreement](http://esotericsoftware.com/spine-editor-license#s2).

## Spine version

spine-cyan_potion works with data exported from Spine 3.8.xx.

spine-cyan_potion supports all Spine features and is the reference runtime implementation.

## Setup

1. Download the Spine Runtimes source using [git](https://help.github.com/articles/set-up-git) or by downloading it as a zip via the download button above.
1. Using Eclipse, import the project by choosing File -> Import -> Existing projects. For other IDEs you will need to create a new project and import the source.

Alternatively, the contents of the `spine-cyan_potion/src` directory can be copied into your project.

## Notes

* The "test" source directory contains optional examples.
* spine-cyan_potion depends on the gdx-backend-lwjgl project so the tests can easily be run on the desktop. If the tests are excluded, spine-cyan_potion only needs to depend on the gdx project.
* spine-cyan_potion depends on the gdx-box2d extension project solely for the `Box2DExample` test.

## Maven & Gradle
The spine-cyan_potion runtime is released to Maven Central through SonaType. 

### Versions



### Maven
To add the spine-cyan_potion runtime to your Maven project, add this dependency:

```
<depenency>
	<groupId>com.esotericsoftware.spine</groupId>
	<artifactId>spine-cyan_potion</artifactId>
	<version>3.5.51.1</version>
</depenency>
```

For SNAPSHOT versions, add the SonaType Snapshot repository to your `pom.xml`:

```
<repositories>
	<repository>
		<id>nightlies</id>
		<url>https://oss.sonatype.org/content/repositories/snapshots/</url>
	</repository>
</repositories>
```

### Gradle
To add the spine-cyan_potion runtime to your cyan_potion Gradle project, add the following dependencies to the `core` project in the `build.gradle` file at the root of your cyan_potion project:

```
project(":core") {
    apply plugin: "java"

    dependencies {
        compile "com.badlogicgames.gdx:gdx:$gdxVersion"
        compile "com.badlogicgames.gdx:gdx-box2d:$gdxVersion"

        compile "com.esotericsoftware.spine:spine-cyan_potion:3.5.51.1"
    }
}
```

## Examples

* [HTML5 example](http://esotericsoftware.com/files/runtimes/spine-cyan_potion/raptor/)
* [Super Spineboy](https://github.com/EsotericSoftware/spine-superspineboy) Full game example done with Spine Essential, includes source code.
* [Simple example 1](spine-cyan_potion-tests/src/com/esotericsoftware/spine/SimpleTest1.java) Simplest possible example, fully commented.
* [Simple example 2](spine-cyan_potion-tests/src/com/esotericsoftware/spine/SimpleTest2.java) Shows events and bounding box hit detection.
* [Simple example 3](spine-cyan_potion-tests/src/com/esotericsoftware/spine/SimpleTest3.java) Shows mesh rendering and IK using the raptor example.
* [More examples](spine-cyan_potion-tests/src/com/esotericsoftware/spine/)
