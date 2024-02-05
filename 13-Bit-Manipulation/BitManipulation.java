import java.util.Scanner;
public class BitManipulation {
    public int getBit(int no, int pos){
        int idx = pos-1;
        int bitMask = 1<<idx;
        if((no & bitMask) == 0){
            return 0;
        }
        else{
            return 1;
        }
    }
    public int setBit(int no, int pos){
        int idx = pos-1;
        int bitMask = 1<<idx;
        return bitMask | no;
    }
    public int clearBit(int no, int pos){
        int idx = pos-1;
        int bitMask = 1<<idx;
        int newBitMask = ~(bitMask);
        return newBitMask & no;
    }
    public int updateBit(int no, int pos){
        int opt = getBit(no,pos);
        if(opt == 1){
            return clearBit(no,pos);
        }
        else{
            return setBit(no,pos);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BitManipulation bm = new BitManipulation();
        while(true){
            System.out.println("1.Get-Bit");
            System.out.println("2.Set-Bit");
            System.out.println("3.Clear-Bit");
            System.out.println("4.Update-Bit");
            System.out.println("0.Exit");
            System.out.println("Enter Your Choice");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter Number And Position:");
                    int no = sc.nextInt();
                    int pos = sc.nextInt();
                    System.out.println(bm.getBit(no,pos));
                break;
                case 2:
                    System.out.println("Enter Number And Position:");
                    int no1 = sc.nextInt();
                    int pos1 = sc.nextInt();
                    System.out.println(bm.setBit(no1,pos1));
                break;
                case 3:
                    System.out.println("Enter Number And Position:");
                    int no2 = sc.nextInt();
                    int pos2 = sc.nextInt();
                    System.out.println(bm.clearBit(no2,pos2));
                break;
                case 4:
                    System.out.println("Enter Number And Position:");
                    int no3 = sc.nextInt();
                    int pos3 = sc.nextInt();
                    System.out.println(bm.updateBit(no3,pos3));
                break;
                case 0:
                    return;
                default:
                    System.out.println("You Entered Wrong Choice..");
                break;
            }
        }
    }
}
