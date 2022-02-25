import java.util.*;

public class Demo {
    public static void main(String[] args)
    {
       /* List<Integer> olist1=new ArrayList<Integer>();
        olist1.add(2);
        olist1.add(2);
        olist1.add(7);
        olist1.add(9);
        olist1.add(7);
        Set<Integer> set=new HashSet<>(olist1);
        List<Object> olist2=Arrays.asList(set.toArray());


        //List<Integer> olist2=new ArrayList<Integer>());
        Collections.reverse(olist2);
        System.out.println(olist2);
        */
        String str="I am an Indian national";
       String[] strArr=str.split("\\s+");

        String result="";
        String word="";
      for(int i=strArr.length-1;i>=0;i--) {

          if(result!=" ") {
              result=result+" "+strArr[i];
          }else{
              result=strArr[i];
          }
      }
        System.out.println(result);
      URI
Response res=RestAssured.given.when().get().param(date,).response();
Assert.assertEqual(res.deviceLastSeen,"\"2020-05-08T01:01:33Z\"");







    }

}
