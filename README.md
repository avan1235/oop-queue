# Queue of Integers

Your task is to implement `FIFOIntQueue` and `FIFOIntQueue` that has to be implemented with the usage of
`IntQueueNode` class and has to satisfy the set of methods defined in `AbstractIntQueue` class (
so definitely this time you cannot use lists and arrays for your implementation).

You can add new classes, new constructors, fields, methods to existing classes. Your solution has to pass some basic
tests from the `FIFOTest` and `LIFOTest` test definitions. You can run them from console with
`gradlew` wrapper

```shell
./gradlew test
```

or using GUI of your IDE as you did during some previous task.

Your task is also to add at least two mentioned small tests of your implementation in `FIFOTest` and `LIFOTest`
in places marked with `TODO`.

The last part is to work a little with the documentation of your classes - let's notice that provided documentation
in `AbstractIntQueue` e.g. for `offer` says nothing about the order of adding the element to the queue - your task is to
provide some more detailed documentation if it's not obvious how the method would behave (it'll automatically overwrite
the documentation from the parent class).

In your code you can also add new methods to different queue classes as you did in your queue diagram model - name them
property, and then they won't even need any documentation 😉

You have time until the end of 09.04.2022

## Extra notes

1. If you want to run your code, and you don't use the IDE that provides magic green buttons for running
   `main` function, you can run it with

    ```shell
    ./gradlew shadowJar
    java -jar ./build/libs/oop-2022-all.jar
    ```

   which will first package all your classes and dependencies to `oop-2022-all.jar` file and then run it on JVM.
2. Remember about cleaning your code and revisiting visibility modifiers before sending solution as now you can loose
   points for bad approach here.
3. Write any time with any questions about the task if you want.
