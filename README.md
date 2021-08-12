# Java 8

This repository contain all the Java 8 related concepts and examples.

##### Notes:

##### Lambda & Functional Interface 

Java 8 introducted 4 Type of Interfaces and any lambda function written is adhered to this interface.

1.Consumer Interface 

This interface only passes parameters and no return value.

* Standard
 
```sh
Consumer<T> consumer=new Consumer<T>() {
	
	@Override
	public void accept(Student t) {
		// TODO Auto-generated method stub
		
	}
};
```
* Lambda
 
```sh
Consumer<T> consumer=((T s)->{
	System.out.println(s);
});
```
* Methods:
 
	* andThen : combines consumer with another consumer

2.BiConsumer : is similar to the consumer but user 2 parameters.

3.Supplier Interface 

This interface only returns value.

* Standard
 
```sh
Supplier<T> supplier=new Supplier<T>() 
	
	@Override
	public Student get() {
		// TODO Auto-generated method stub
		return null;
	}
};
```
* Lambda
 
```sh
Supplier<Student> supplier=(()->{
	return null;
});
```
4.Predicate

This interface is used to validate the input and returns boolean only 


* Standard
 
```sh
Predicate<T> predicate=new Predicate<T>() {

	@Override
	public boolean test(T t) {
		// TODO Auto-generated method stub
		return false;
	}
};
```
* Lambda
 
```sh
Predicate<T> predicate=((T t)->{
	 return false;
});
```
* Methods:
 
	* and  : compares 2 predicate expression with and
	
	* or   : compares 2 predicate expression with or
	
	* negate : inverse operation on the expression result

5.BiPredicate : Similar to the Predicate difference it uses 2 parameters.
6.Functions: 

This is used when there is a parameter sent and there is a return value.

* Standard
 
```sh
Function<Student,Student> function=new Function<Student, Student>() {

	@Override
	public Student apply(Student t) {
		// TODO Auto-generated method stub
		return null;
	}
};
```
* Lambda
 
```sh
Function<Student, Student> fucn = ((Student a) -> {
	return null;
});
```
	>> andThen : combines function with another function.

7.BiFunction : is similar to the function interface difference is it take 2 parameters.

8.UnaryOperator : is similar to the function interface difference is the data type of the parameter send and returned are same. 

9.BinaryOperator :  is similar to the UnaryOperator interface difference is it takes 2 parameter and returns one value with all same data type.


#####  Method reference

1.Static Reference. 

```sh

Test::printName , where printName is a static method


is similar to 


(T t)->{
Test.printName(t)
}


```


2.Instance Reference.

```sh

test::printName , where test is an object


is similar to 


(T t)->{
test.printName(t)
}


```

3.Class Reference


```sh
 
Student::printValue , where Student is the name of the class, printValue is the method name


is similar to 


(Student s)->{
 s.printValue()
}

```


4.Constructor Reference 


```sh
 public static void constructorReferenceObject3() {
	BiFunction<String, String, Test> biFunc = Test::new;
	Test test=biFunc.apply("testI", "testJ");
	System.out.println("I and J value");
	System.out.println(test.getI());
	System.out.println(test.getJ());
}

public static void constructorReferenceObject2() {
	Function<String, String> strFunc = String::new;
	String str = strFunc.apply("hello user");
	System.out.println(str);

}

public static void constructorReferenceObject1() {
	Supplier<String> strFunc = String::new;
	String str = strFunc.get();
	System.out.println(str);

}

```



##### Effectively final: 

* The lambda variable name and the local variable names cannot be same.
* The local variables cannot be modified inside lambda expressions.
* No restrictions for instance variables.
* A local variable used inside a lambda expression is termed as effectively final and cannot be modified any where in the scope.
[Refer](https://github.com/viswarajramji/Java8/blob/master/src/lambda/LambdaLocalVariables.java) 
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
* mapToInt : converts Stream to intStream applies 
* mapToLong : converts Stream to  LongStream.
* mapToDouble : converts Stream to DoubleStream.


##### Stream  - Numeric

######  IntStream 
* rangeClosed: generates series of int values.
* range: generates the series of number excluding the last value.

######  LongStream
* rangeClosed: generates series of long values.
* range: generates the series of number excluding the last value.

######  DoubleStream
* it does not support both rangeClosed and range.


###### Aggregate functions in numeric functions:

* sum: Adds the numeric stream values.
* max: find the max of the numeric stream values.
* min: find the min of the numeric stream values.
* avg: find the avg of the numeric stream values.

###### Boxing and Unboxing of Numeric Streams:

* Boxing :  int -> Integer.

* Unboxing : Integer -> int.

* IntStream:

	* mapToLong : will convert to LongStream.
	
	* mapToDouble : will convert to DoubleStream.
	
	* boxed : will convert intStream to Stream<Integer>.
	
	* mapToObj: will convert to Stream<Object>.

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








 