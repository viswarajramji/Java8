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
* limit: reduces the total number of values in the stream.
* skip : skips the first N elements.
* anyMatch : true if any match happens.
* allMatch : true if all match happens.
* noneMatch : true if none of it matches.
* findAny: return any object from the stream.
* findfirst: return first object from the stream.
* of: converts a values to a stream.
* iterate: this just iterates the values in a loop infinity (Use limit func to limit the iteration)
* generate: this just uses supplier method and the get method is invoked infinity (Use limit func to limit the iteration)

##### Stream  - Numeric

######  intStream
* rangeClosed: generates series of numbers.
* range: generates the series of number excluding the last value.


######  LongStream
* rangeClosed: generates series of numbers.
* range: generates the series of number excluding the last value.
* sum: perform sum in the intStream.

######  DoubleStream
* it does not support both rangeClosed and range. use the alternative approached discussed in the link.

###### Aggregate functions in numeric functions:

* sum:  Adds the numeric stream values.
* max: find the max of the numeric stream values.
* min: find the min of the numeric stream values.
* avg: find the avg of the numeric stream values.

###### Boxing and Unboxing of Numeric Streams

* Boxing :  int -> Integer / unboxing : Integer -> int.
* boxed : will convert intStream to Stream<Integer>
* mapToInt: convert Stream to intputStream.
* mapToDouble: Convert stream to DoubleStream.
* mapToLong: convert Stream to LongStream.
* mapToObj: convert Stream to stream of Objects.

###### Streams API - terminal operations.

The terminal operation is used perform the joining.

* joining : concats the streams of string values.
* counting :   return the total number for entries.
* mapping : would perform a transformation and then collects the values.
* maxBy / minBy : uses a comparator and returns Max / Min value.
* SummingInt/averagingInt || SummingLong / averagingLong || SummingDouble /averagingDouble
* grouping : performs groupby on the field.
* groupBy : By max, min , CollectingAndthen.
* paritioningBy: 


###### Optional

Used to avoid null pointer and to avoid having too many null conditions.

####### Optional Methods

* ofNullable : convert a value to an optional object.
* Of : this method is used if you are 100% sure the value is not null else the method throws an exception.
* empty : this method is a default method








 