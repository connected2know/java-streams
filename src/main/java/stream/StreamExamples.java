package main.java.stream;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExamples {
	
	
	/// Auxiliary test object
	
	static class MyCustomObject{
		
		private String value;
		
		public MyCustomObject(String value) {
			this.value= value;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}
	
	/////////////// INTERMEDIATE OPERATIONS : filter,map,sorted,peek,limit,distinct,skip,flatMap
	/////////////// TERMINAL OPERATIONS : forEach, toArray, min, max, count, anyMatch, allMatch, noneMatch, findFirst, findAny, reduce, collect
	
	public void simpleStreamPeekRightUsed() { 
		
		try {
			String[] myStrings = {"a","b","c","d","e"};
			
			Stream<String> myStream = Stream.of(myStrings);
			myStream.peek(i -> {System.out.println(i + " in PEEK");})
					.forEach((i) -> {System.out.println(i);});
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void simpleStreamPeekNotRightUsed() { 
			
		try {
			MyCustomObject[] myStrings = {new MyCustomObject("a"),new MyCustomObject("b"),new MyCustomObject("c"),
					new MyCustomObject("d"),new MyCustomObject("e")};
			
			Stream<MyCustomObject> myStream = Stream.of(myStrings);
			
			// Peek should not be used for affect values but only for debug purposes
			myStream.peek(i -> {i.setValue(i.getValue() + " NEW ");}).forEach((i) -> {System.out.println(i.getValue());});
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void simpleStreamMapSimple1() { 
			
		try {
			String[] myStrings = {"a","b","c","d","e"};	
			Stream<String> myStream2 = Stream.of(myStrings);
			myStream2.map(s -> s + " new Mapped").forEach((i) -> {System.out.println(i);});
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	

	public void simpleStreamMapSimple2() { 
		
		try {
			MyCustomObject[] myStrings = {new MyCustomObject("a"),new MyCustomObject("b"),new MyCustomObject("c"),
					new MyCustomObject("d"),new MyCustomObject("e")};
			
			Stream<MyCustomObject> myStream = Stream.of(myStrings);
			
			// Peek should not be used for affect values but only for debug purposes
			myStream.map(s -> { 
							s.setValue( s.getValue() + " MAPPED"); 
							return s.getValue();}
						).forEach((i) -> {System.out.println(i);});
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	// Map to a new Object
	public void simpleStreamMapNewObject1() { 
		
		try {
			String[] myStrings = {"a","b","c","d","e"};	
			
			Stream<String> myStream = Stream.of(myStrings);
			
			// Peek should not be used for affect values but only for debug purposes
			myStream.map(s -> { 
							MyCustomObject obj = new MyCustomObject(s);
							obj.setValue( obj.getValue() + " MAPPED to new OBJ"); 
							return obj;}
						).forEach((i) -> {System.out.println(i.getValue());});
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void simpleStreamSortedSimple1() { 
		
		try {
			String[] myStrings = {"c","b","a","e","d"};	
			Stream<String> myStream2 = Stream.of(myStrings);
			myStream2.sorted().forEach((i) -> {System.out.println(i);});
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void simpleStreamSortedSimple2() { 
		
		try {
			String[] myStrings = {"c","b","a","e","d"};	
			Stream<String> myStream2 = Stream.of(myStrings);
			myStream2.sorted(Collections.reverseOrder()).forEach((i) -> {System.out.println(i);});
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void simpleStreamSortedSimple3() { 
		
		try {
			MyCustomObject[] myStrings = {new MyCustomObject("e"),new MyCustomObject("d"),new MyCustomObject("c"),
					new MyCustomObject("b"),new MyCustomObject("a")};
			
			Stream<MyCustomObject> myStream = Stream.of(myStrings);
			
			myStream.sorted(Collections.reverseOrder(Comparator.comparing(MyCustomObject::getValue))).forEach((i) -> {System.out.println(i.getValue());});
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void simpleStreamFilterSimple1() { 
		
		try {
			Integer[] myIntegers = {1,2,3,4,5};	
			
			Stream<Integer> myStream = Stream.of(myIntegers);

			myStream.filter(s ->  s > 3 ).forEach((i) -> {System.out.println(i);});
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void simpleStreamFilterSimple2() { 
		
		try {
			MyCustomObject[] myIntegersObjs = {new MyCustomObject("1"),new MyCustomObject("2"),new MyCustomObject("3"),
					new MyCustomObject("4"),new MyCustomObject("5")};
			
			Stream<MyCustomObject> myStream = Stream.of(myIntegersObjs);

			myStream.filter(s ->  {
				
									boolean result = false;
									try {
										result = Integer.valueOf(s.getValue()) > 2;
									}catch(Exception e) {
										System.out.println("Exception:" + e.getMessage());	
									}
									return result;
									
									}).forEach((i) -> {System.out.println(i.getValue());});
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void simpleStreamFilterSimple3() { 
		
		try {
			MyCustomObject[] myIntegersObjs = {new MyCustomObject("1"),new MyCustomObject("2"),new MyCustomObject("3"),
					new MyCustomObject("4"),new MyCustomObject("a")};
			
			Stream<MyCustomObject> myStream = Stream.of(myIntegersObjs);

			myStream.filter(s ->  {
									boolean result = false;
									try {
										result = Integer.valueOf(s.getValue()) > 2;
									}catch(Exception e) {
										System.out.println("Exception:" + e.getMessage());	
									}
									return result;
									
			}).forEach((i) -> {System.out.println(i.getValue());});
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void simpleStreamLimitSimple1() { 
		
		try {
			Integer[] myIntegers = {1,2,3,4,5};	
			
			Stream<Integer> myStream = Stream.of(myIntegers);

			myStream.limit(4).forEach((i) -> {System.out.println(i);});
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void simpleStreamSkipSimple1() { 
		
		try {
			Integer[] myIntegers = {1,2,3,4,5};	
			
			Stream<Integer> myStream = Stream.of(myIntegers);

			myStream.skip(4).forEach((i) -> {System.out.println(i);});
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void simpleStreamLimitSkipSimple1() { 
		
		try {
			Integer[] myIntegers = {1,2,3,4,5};	
			
			Stream<Integer> myStream = Stream.of(myIntegers);

			myStream.limit(4).skip(2).forEach((i) -> {System.out.println(i);});
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void simpleStreamDistinctSimple1() { 
		
		try {
			Integer[] myIntegers = {1,2,3,4,5,2,3,4,2,3,4};	
			
			Stream<Integer> myStream = Stream.of(myIntegers);

			myStream.distinct().forEach((i) -> {System.out.println(i);});
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	
    public void simpleStreamDistinctSimple2() { 
		
		try {
			MyCustomObject[] myIntegersObjs = {new MyCustomObject("1"),new MyCustomObject("2"),new MyCustomObject("a"),new MyCustomObject("3"),
					new MyCustomObject("4"),new MyCustomObject("a"),new MyCustomObject("4"),new MyCustomObject("a"),new MyCustomObject("2")};
			
			Stream<MyCustomObject> myStream = Stream.of(myIntegersObjs);

			myStream.map(s -> s.getValue()).distinct().forEach((i) -> {System.out.println(i);});
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
    
    ///////////////////////// TERMINAL OPERATIONS
    
    public void simpleStreamToArraySimple1() { 
		try {
			Integer[] myIntegers = {1,2,3,4,5,2,3,4,2,3,4};	
			Stream<Integer> myStream = Stream.of(myIntegers);
			Integer[] partialRes = myStream.distinct().toArray(Integer[]::new);
			Stream.of(partialRes).forEach((i) -> {System.out.println(i);});
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
    
    
    public void simpleStreamToArraySimple2() { 
		try {

			MyCustomObject[] myIntegersObjs = {new MyCustomObject("1"),new MyCustomObject("2"),new MyCustomObject("a"),new MyCustomObject("3"),
					new MyCustomObject("4"),new MyCustomObject("a"),new MyCustomObject("4"),new MyCustomObject("a"),new MyCustomObject("2")};
			
			Stream<MyCustomObject> myStream = Stream.of(myIntegersObjs);
			
			Integer[] partialRes = myStream.map(
						s -> {
							Integer val = -1;
							try {
								 val = Integer.valueOf(s.getValue());
							}catch(Exception e) {
								//System.out.println("Not valid integer:" + s.getValue());
							}
							return val; 
						}).distinct().toArray(Integer[]::new);
			
			Stream.of(partialRes).forEach((i) -> {System.out.println(i);});
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
    
    
    public void simpleStreamMinSimple1() { 
		
		try {
			Integer[] myIntegers = {1,2,3,4,5,2,3,4,2,-1,3,4};	
			Stream<Integer> myStream2 = Stream.of(myIntegers);
			Optional<Integer> optResult = myStream2.sorted(Collections.reverseOrder()).min(Integer::compare);
			if(optResult.isPresent()) {
				System.out.println("Result: " + optResult.get());
			}
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
    
    
    public void simpleStreamMinSimple2() { 
		
		try {
			MyCustomObject[] myIntegersObjs = {new MyCustomObject("z"),new MyCustomObject("f"),new MyCustomObject("a"),new MyCustomObject("b"),
					new MyCustomObject("m"),new MyCustomObject("a"),new MyCustomObject("h"),new MyCustomObject("a"),new MyCustomObject("j")};
			
			Stream<MyCustomObject> myStream2 = Stream.of(myIntegersObjs);//MyCustomObject::getValue
			
			Optional<MyCustomObject> optResult = myStream2.min(Comparator.comparing(s -> {
				return s.getValue();
			}));
			if(optResult.isPresent()) {
				System.out.println("Result: " + optResult.get().getValue());
			}
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
    
    
    public void simpleStreamMaxSimple1() { 
		
		try {
			Integer[] myIntegers = {1,2,3,4,5,2,3,4,2,-1,3,4};	
			Stream<Integer> myStream2 = Stream.of(myIntegers);
			Optional<Integer> optResult = myStream2.sorted(Collections.reverseOrder()).max(Integer::compare);
			if(optResult.isPresent()) {
				System.out.println("Result: " + optResult.get());
			}
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
    
    
    public void simpleStreamMaxSimple2() { 
		
		try {
			MyCustomObject[] myIntegersObjs = {new MyCustomObject("z"),new MyCustomObject("f"),new MyCustomObject("a"),new MyCustomObject("b"),
					new MyCustomObject("m"),new MyCustomObject("a"),new MyCustomObject("h"),new MyCustomObject("a"),new MyCustomObject("j")};
			
			Stream<MyCustomObject> myStream2 = Stream.of(myIntegersObjs);//MyCustomObject::getValue
			
			Optional<MyCustomObject> optResult = myStream2.max(Comparator.comparing(s -> {
				return s.getValue();
			}));
			if(optResult.isPresent()) {
				System.out.println("Result: " + optResult.get().getValue());
			}
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
    
    
    
    public void simpleStreamCountSimple1() { 
		
		try {
			Integer[] myIntegers = {1,2,3,4,5,2,3,4,2,-1,3,4};	
			Stream<Integer> myStream2 = Stream.of(myIntegers);
			Long optResult = myStream2.sorted(Collections.reverseOrder()).count();
			System.out.println("Result: " + optResult);

		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
    
    
    public void simpleStreamCountSimple2() { 
		
		try {
			MyCustomObject[] myIntegersObjs = {new MyCustomObject("z"),new MyCustomObject("f"),new MyCustomObject("a"),new MyCustomObject("b"),
					new MyCustomObject("m"),new MyCustomObject("a"),new MyCustomObject("h"),new MyCustomObject("a"),new MyCustomObject("j")};
			
			Stream<MyCustomObject> myStream2 = Stream.of(myIntegersObjs);//MyCustomObject::getValue
			
			Long optResult = myStream2.count();
			System.out.println("Result: " + optResult);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
    
    
    
    public void simpleStreamAnyMatchSimple1() { 
		
		try {
			Integer[] myIntegers = {1,2,3,4,5,2,3,4,2,-1,3,4};	
			Stream<Integer> myStream2 = Stream.of(myIntegers);
			Boolean optResult = myStream2.sorted(Collections.reverseOrder()).anyMatch(i -> i > 9);
			System.out.println("Result: " + optResult);

		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
    
    
    public void simpleStreamAnyMatchSimple2() { 
		
		try {
			MyCustomObject[] myIntegersObjs = {new MyCustomObject("z"),new MyCustomObject("f"),new MyCustomObject("a"),new MyCustomObject("b"),
					new MyCustomObject("m"),new MyCustomObject("a"),new MyCustomObject("h"),new MyCustomObject("a"),new MyCustomObject("j")};
			
			Stream<MyCustomObject> myStream2 = Stream.of(myIntegersObjs);//MyCustomObject::getValue
			
			Boolean optResult = myStream2.anyMatch(i -> "h".contentEquals(i.getValue()));
			System.out.println("Result: " + optResult);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
    
    
    public void simpleStreamAllMatchSimple1() { 
		
		try {
			Integer[] myIntegers = {1,2,3,4,5,2,3,4,2,-1,3,4};	
			Stream<Integer> myStream2 = Stream.of(myIntegers);
			Boolean optResult = myStream2.sorted(Collections.reverseOrder()).anyMatch(i -> i > -2);
			System.out.println("Result: " + optResult);

		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
    
    
    public void simpleStreamAllMatchSimple2() { 
		
		try {
			MyCustomObject[] myIntegersObjs = {new MyCustomObject("z"),new MyCustomObject("f"),new MyCustomObject("a"),new MyCustomObject("b"),
					new MyCustomObject("m"),new MyCustomObject("a"),new MyCustomObject("h"),new MyCustomObject("a"),new MyCustomObject("j")};
			
			Stream<MyCustomObject> myStream2 = Stream.of(myIntegersObjs);//MyCustomObject::getValue
			
			Boolean optResult = myStream2.anyMatch(i -> 1 == i.getValue().length());
			System.out.println("Result: " + optResult);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
    
    public void simpleStreamNoneMatchSimple1() { 
		
		try {
			Integer[] myIntegers = {1,2,3,4,5,2,3,4,2,-1,3,4};	
			Stream<Integer> myStream2 = Stream.of(myIntegers);
			Boolean optResult = myStream2.sorted(Collections.reverseOrder()).noneMatch(i -> i > -2);
			System.out.println("Result: " + optResult);

		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
    
    
    public void simpleStreamNoneMatchSimple2() { 
		
		try {
			MyCustomObject[] myIntegersObjs = {new MyCustomObject("z"),new MyCustomObject("f"),new MyCustomObject("a"),new MyCustomObject("b"),
					new MyCustomObject("m"),new MyCustomObject("a"),new MyCustomObject("h"),new MyCustomObject("a"),new MyCustomObject("j")};
			
			Stream<MyCustomObject> myStream2 = Stream.of(myIntegersObjs);//MyCustomObject::getValue
			
			Boolean optResult = myStream2.noneMatch(i -> 2 == i.getValue().length());
			System.out.println("Result: " + optResult);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
    
    
    public void simpleStreamFindFirstSimple1() { 
		
		try {
			Integer[] myIntegers = {1,2,3,4,5,2,3,4,2,-1,3,4};	
			Stream<Integer> myStream2 = Stream.of(myIntegers);
			Optional<Integer> optResult = myStream2.sorted(Collections.reverseOrder()).findFirst();
			
			if(optResult.isPresent()) {
				System.out.println("Result: " + optResult.get());
			}

		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
    
    
    public void simpleStreamFindFirstSimple2() { 
		
		try {
			MyCustomObject[] myIntegersObjs = {new MyCustomObject("z"),new MyCustomObject("f"),new MyCustomObject("a"),new MyCustomObject("b"),
					new MyCustomObject("m"),new MyCustomObject("a"),new MyCustomObject("h"),new MyCustomObject("a"),new MyCustomObject("j")};
			
			Stream<MyCustomObject> myStream2 = Stream.of(myIntegersObjs);//MyCustomObject::getValue
			
			Optional<MyCustomObject> optResult = myStream2.findFirst();
			
			if(optResult.isPresent()) {
				System.out.println("Result: " + optResult.get().getValue());
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
    
    
    public void simpleStreamFindAnySimple1() { 
		
		try {
			Integer[] myIntegers = {1,2,3,4,5,2,3,4,2,-1,3,4};	
			Stream<Integer> myStream2 = Stream.of(myIntegers);
			Optional<Integer> optResult = myStream2.sorted(Collections.reverseOrder()).findAny();
			
			if(optResult.isPresent()) {
				System.out.println("Result: " + optResult.get());
			}

		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
    
    
    public void simpleStreamFindAnySimple2() { 
		
		try {
			MyCustomObject[] myIntegersObjs = {new MyCustomObject("z"),new MyCustomObject("f"),new MyCustomObject("a"),new MyCustomObject("b"),
					new MyCustomObject("m"),new MyCustomObject("a"),new MyCustomObject("h"),new MyCustomObject("a"),new MyCustomObject("j")};
			
			Stream<MyCustomObject> myStream2 = Stream.of(myIntegersObjs);//MyCustomObject::getValue
			
			Optional<MyCustomObject> optResult = myStream2.findAny();
			
			if(optResult.isPresent()) {
				System.out.println("Result: " + optResult.get().getValue());
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
    
    
    
    public void simpleStreamCollectSimple1() { 
		
		try {
			Integer[] myIntegers = {1,2,3,4,5};	
			Stream<Integer> myStream2 = Stream.of(myIntegers);
			Map<String,Integer> optResult = myStream2.sorted(Collections.reverseOrder()).collect(
					Collectors.toMap(x -> String.valueOf(x),x -> x)
					);

			System.out.println("Result: " + optResult.get("5"));


		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
    
    
    public void simpleStreamCollectSimple2() { 
		
		try {
			MyCustomObject[] myIntegersObjs = {new MyCustomObject("z"),new MyCustomObject("f"),new MyCustomObject("a"),new MyCustomObject("b")};
			
			Stream<MyCustomObject> myStream2 = Stream.of(myIntegersObjs);//MyCustomObject::getValue
			
			Map<String,MyCustomObject> optResult = myStream2.collect(Collectors.toMap(x -> x.getValue() ,x -> x));
			System.out.println("Result: " + optResult.get("f"));
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
    
    
    
    public void simpleStreamReduceSimple1() { 
		
		try {
			Integer[] myIntegers = {1,2,3,4,5};	
			Stream<Integer> myStream2 = Stream.of(myIntegers);
			Integer optResult = myStream2.sorted(Collections.reverseOrder()).reduce(0,(x,y) -> x + y);

			System.out.println("Result: " + optResult);


		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
    
    
   
	
	public static void main(String[] args) {
		
		StreamExamples obj = new StreamExamples();
		
		//obj.simpleStreamPeekRightUsed();
		//obj.simpleStreamPeekNotRightUsed();
		//obj.simpleStreamMapSimple1();
		//obj.simpleStreamMapSimple2();
		//obj.simpleStreamMapNewObject1();
		//obj.simpleStreamSortedSimple1();
		//obj.simpleStreamSortedSimple2();
		//obj.simpleStreamSortedSimple3();
		//obj.simpleStreamFilterSimple1();
		//obj.simpleStreamFilterSimple2();
		//obj.simpleStreamFilterSimple3();
		//obj.simpleStreamLimitSimple1();
		//obj.simpleStreamSkipSimple1();
		//obj.simpleStreamLimitSkipSimple1();
		//obj.simpleStreamDistinctSimple1();
		//obj.simpleStreamDistinctSimple2();
		
		//obj.simpleStreamToArraySimple1();
		//obj.simpleStreamToArraySimple2();
		//obj.simpleStreamMinSimple1();
		//obj.simpleStreamMinSimple2();
		//obj.simpleStreamMaxSimple1();
		//obj.simpleStreamMaxSimple2();
		//obj.simpleStreamCountSimple1();
		//obj.simpleStreamCountSimple2();
		//obj.simpleStreamAnyMatchSimple1();
		//obj.simpleStreamAnyMatchSimple2();
		//obj.simpleStreamAllMatchSimple1();
		//obj.simpleStreamAllMatchSimple2();
		//obj.simpleStreamNoneMatchSimple1();
		//obj.simpleStreamNoneMatchSimple2();
		//obj.simpleStreamFindFirstSimple1();
		//obj.simpleStreamFindFirstSimple2();
		//obj.simpleStreamFindAnySimple1();
		//obj.simpleStreamFindAnySimple2();
		//obj.simpleStreamCollectSimple1();
		//obj.simpleStreamCollectSimple2();
		obj.simpleStreamReduceSimple1();

	}

	
}
