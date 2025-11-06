import java.util.Scanner;

public class PE05_CastellonAlbert {
    
    String comand = "";
    Scanner escaner = new Scanner(System.in);
    double totalImport = 0;
    
    public static void main(String[] args) {
        PE05_CastellonAlbert p = new PE05_CastellonAlbert();
        p.principal();

    }
    

    public void principal() {
        
        int mainMenu = 0;
        do {

        
            System.out.println("Què vols fer?");
            System.err.println("1. Crear una nova comanda");
            System.out.println("2. Modificar comanda");
            System.out.println("3. Visualitzar tiquet");
            System.out.println("4. Sortir");
            mainMenu = escaner.nextInt();
            switch (mainMenu) {
                case 1:
                    comand += createTiquet();
                    System.out.println(comand);
                    break;
            
                default:
                    break;
            }
            
        }while(mainMenu == 0);
    }

    public String createTiquet(){

        String tiquet = "", name = "";
        String control = "s";

        System.out.println("Introdueix nom del client:");
        name = escaner.next();

        tiquet = "Client: " + name + "\nProducte\tQuantitat\tPreu unitari\tSubtotal\n" ;

        while (control.equals("s")) {

            tiquet = tiquet + "\n" + addLine();
            System.out.println("Vols afegir algun producte més? (s/n)");
            control = escaner.next();

        }
        return tiquet;
    }
    public String addLine() {

        String nameProduct = "";
        double unitPrice = 0;
        int productUnits = 0;
        String line = "";

        System.out.print("Introdueix el producte: \t");
        nameProduct = escaner.next();
        System.out.println("");

        System.out.print("Preu unitari: \t");
        unitPrice = escaner.nextDouble();
        System.out.println("");

        System.out.print("Quantitat: \t");
        productUnits = escaner.nextInt();
        System.out.println("");
        
        totalImport += unitPrice * productUnits;
        line = nameProduct + "\t" + productUnits + "\t" + unitPrice + " € \t" + unitPrice*productUnits + "\n";
        
        return line;
    }
}
