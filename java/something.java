import java.util.Scanner;


public class something
{
    public static void main(String[] args)
    {
        try (Scanner myObj = new Scanner(System.in))
        {
            int kPeople = myObj.nextInt();
            int nPlanes = myObj.nextInt();
            int sPlanesFromSheet = myObj.nextInt();
            int pPacks =  myObj.nextInt();

            double sheetsNeeded = kPeople * Math.ceil((double) nPlanes / sPlanesFromSheet);

            int packsNeeded = (int) Math.ceil(sheetsNeeded/pPacks);

            System.out.println(packsNeeded);
        }
    }

}