import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Lanterns
{
    public static void main(String[] args)
    {
        Scanner myObj = new Scanner(System.in);

        int n = myObj.nextInt(), l = myObj.nextInt();

        List<Integer> lanterns = new ArrayList<>();

        for(int i = 0; i < n; i++)
        {
            lanterns.add(myObj.nextInt());
        }

        lanterns.sort(Comparator.naturalOrder());

        if(lanterns.get(0) != 0)
            lanterns.add(0, -1 * lanterns.get(0));
        if(lanterns.get(lanterns.size() - 1) != l)
            lanterns.add(2 * l - lanterns.get(lanterns.size() - 1));

        System.out.println( (double) biggestConsDiff(lanterns) / 2);
    }

    public static int biggestConsDiff(List<Integer> list)
    {
        Iterator<Integer> itr = list.iterator();

        int prev = 0, cur = 0, max = 0;

        while(itr.hasNext())
        {
            cur = itr.next();
            if(cur - prev > max)
                max = cur - prev;
            
            prev = cur;
        }

        return max;
    }
}
