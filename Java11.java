import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Version;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
 * 
 * This class demonstrate the practicle guide for of java 11 features
 * 
 * LTS 2026 
*/

public class Java11 {
    
    /*
    run the java file in single  command
    String utility class 
    isBlank() --> boolean value empty
    lines()  --> stream of strings 
    strip(), stripLeading(), stripTrailing()  why trim() 
      
    */
    public static void main(String[] args) {
        System.out.println("Hello from java11");
        String blank1="";
        String blank2=new String();
        String blank3="sometext";
        System.out.println("isBlank1 :: "+blank1.isEmpty());
        System.out.println("isBlank2 :: "+blank2.isEmpty());
        System.out.println("isBlank3 :: "+blank3.isEmpty());

        
        String noOfLinesSet="Hello\nMy\nJava11\nHello\nMy\nJava11";

       System.out.println("lines \n "+noOfLinesSet.lines().collect(Collectors.toList()));
       
       System.out.println("lines Set \n "+noOfLinesSet.lines().collect(Collectors.toSet()));

       String str="  I have a string ";

       System.out.println("stripLeading "+str.stripLeading());
       System.out.println("stripTrailing "+str.stripTrailing());
       System.out.println("strip "+str.strip());

       // repeat
       System.out.println(" repeat demo :: "+"I am ".repeat(5));

       // local variable lambda parameters
       // (var a, var b)-> a + b --> valid 
       // (a,b)-> a+b  --> valid
       // (var a, int b)-> a+b--> invalid
            
       

       System.out.println(
           Arrays.asList("Hello","world").stream()
           .map((var x )->x.toUpperCase())
       .collect(Collectors.joining(" ")));

        //HTTPClient and support http1.1 and http2.0 

        HttpClient client=HttpClient.newBuilder().version(Version.HTTP_2)
        .connectTimeout(Duration.ofSeconds(10))
        .build();
        
        HttpRequest request=HttpRequest.newBuilder()
        .GET().uri(URI.create("http://localhost:80/get")).build();

        try {
            HttpResponse res= client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

   // nested access control
   //JEP 309 dynamic class file constants
   // JEP 318 Epsilon A no op garbage collector, performance testing,
   // --XX:+UnlockExperimentatlVMOptions --XX:+UserEpsilonGCFLag
   // Removed Java EE and CORBA 
   // readString and WriteString to and from files

   try {
    Path path= Files.writeString(Files.createTempFile("testing", ".txt"),"THis is demo file");
} catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}

    }
}
