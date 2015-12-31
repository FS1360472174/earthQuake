# earthQuake
概要：
这个项目主要供java 初级到中级水平参考
有兴趣的coder可以一起来做

the exercise project for Course Principle of Software Design

some created by the class,some designed by myself


- Exercise1---Sort
	
	1.简单排序
		
       Refer:QuakeSort.java sortByMagnitude method

	2.冒泡排序

	   Refer:QuakeSort.java sortByMagnitudeWithBubbleSort method
	
	3.快速排序(使用Java API)
	
	method1:
	
	class 实现 Comparable<T>接口，重写compareTo方法,然后使用Collections.sort(Object)方法调用。
	
	Refer:QuakeEntry.java以及测试方法DifferentSorters.sortByMagnitudeThenDepth

	method2:
	
	class 实现Comparator<T>接口，重写compare方法,然后使用Collections.sort(Object,compartor)方法调用
	
	Refer:DifferentSorter.java sortByTitleThenDepth method.