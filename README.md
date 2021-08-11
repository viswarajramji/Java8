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

The terminal operations are used to finalize the stream process and helps in fetching the result.

All the below methods belongs to Collectors class and is used with stream.collect().

* joining : concats the streams of string values, It has 3 variations -  joining , joining(delimiter) , joining(delimiter, prefix , suffix).
* counting :   return the total number for entries.
* mapping : would perform a transformation and then collects the values.
* maxBy / minBy : uses a comparator and returns Max / Min value.
* Sum : perform sum value 
 1.  Int : SummingInt  
 2.  Long: SummingLong
 3.  Double : SummingDouble
 
* Avg : perform average value 
 1.  Int : averagingInt
 2.  Long: averagingLong
 3.  Double : averagingDouble

* groupBy - 3 variations exists
* paritioningBy: perform classification by true/false

###### Optional

Used to avoid null pointer and to avoid having too many null conditions.

###### Optional Methods
* valueOf : convert a value to Optional object.
* ofNullable : convert a value to an optional object.
* Of : this method is used if you are 100% sure the value is not null else the method throws an exception.
* get : fetch the value of optional
* empty : this method is a default method
* orElse: this method is used to print the default value if the optional value is null.
* orElseGet: this method is used to print the supplier value if the optional value is null.
* orElseThrow : This  method is going to throw a runtime exception.
* isPresent: check if the optional has some values or not.
* ifPresent: check if the optional has some values or not if yes then the consumer method is called to use that value.
* filter: performs the predicate of the filter method.
* map: this method maps the values of the optional parameter.
* flatMap: Used to fetch the value of optional inside an optional object
Ex: Optional<Student -> Optional<Bike>>

###### Default/Static methods
* default : in this method, we can write default logic or override the method.
* static:  cannot be overriden.

Note : Precedence order if a method is overridden in the child and is invoked then the child takes the precedence over the parent.

###### Comparator
* Comparator.naturalOrder : sort asc
* Comparator.reverseOrder : sort desc
* Comparator.comparing(Function<U,R>): sort by specific attribute.
* Comparator.andThen(Comparator) :  sort by specific multi attribute.
* Comparator.nullFirst : handles null execption and moves all the null values to the first
* Comparator.nullLast:  handles null execption and moves all the null values to the Last








 