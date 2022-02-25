import java.util.*;

public class Demo {

    public static void main(String[] args) {
        /***
         * 1010001010
         */
String s="1010001010";
String[] strArr=s.split("1");
int max=0;
for(int i=0;i<strArr.length;i++){
    if(strArr[i].length()>max)
    {
        max=strArr[i].length();
    }
}
System.out.println(max);
    }
}

    /***
     * Check wheather string contains 0 or not
     * string length should be greater than 0,
     * if there is same consecutive 0,then it should return max
     Assert.assertEquals("!@#$%&","0")
     performance testing

     */

/**
 * Manager-managerid,name,place,empid
 * employee-eid,ename,eplace
 *
 * sdelect ename from employee where eid in (Seelct empid from manager wher managerid=105)
 * select ename from employee e1 inner join Manager m1 on e1.eid=m1.empid where m1.managerid=105
 * select eplace,count(*) as Total_Cnt from employee group by eplace order by  desc
 * select eplace,max(
 */



