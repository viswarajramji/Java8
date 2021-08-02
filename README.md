# Java 8

This repository contain all the Java 8 related concepts and examples.

##### Notes:

##### Lambda:

* The lambda variable name and the local variable names cannot be same.
* The local variables cannot be modified inside lambda expressions.
* No restrictions for instance variables.
* A local variable used inside a lambda expression is termed as effectively final. [Refer](https://github.com/viswarajramji/Java8/blob/master/src/lambda/LambdaLocalVariables.java) 
* In General until Java 7, Any variables used inside anonymous function must be declared as final. 



##### Streams:

* Collect method is the one that invokes the streams.
* Streams are lazy loading.


###### Stream Methods:
* map : converts stream from one form to another.
* flatMap : converts stream from one form to another applies when List / Array to flat structure.
* distinct : Unique values
* count : Number of values
* sorted: sorts the result
* sorted(Customization): sorts the result
* filter: filters records by predicate
* reduce: its a terminal operation , used to reduce the content to a single value.

Syntax:

reduce(InitialValue,BinaryFunc)






