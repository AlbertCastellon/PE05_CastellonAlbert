import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PE05_CastellonAlbert {
    
    String ImportTally = "";
    Scanner escaner = new Scanner(System.in);
    double totalImport = 0;
    DecimalFormat df = new DecimalFormat("#.00");
    
    public static void main(String[] args) {
        PE05_CastellonAlbert p = new PE05_CastellonAlbert();
        p.principal();

    }
    
    public void principal() {
        
        int mainMenu = 0;
        boolean exit = false;
        String comand = "";
        do {

        
            System.out.println("Què vols fer?");
            System.err.println("1. Crear una nova comanda");
            System.out.println("2. Modificar comanda");
            System.out.println("3. Visualitzar tiquet");
            System.out.println("4. Sortir");
            try{
                mainMenu = escaner.nextInt();
            }catch(InputMismatchException e) {
               System.out.println("Error: opció invàlida"); 
            }
            
            switch (mainMenu) {
                case 1:
                    comand = "";
                    totalImport = 0;
                    comand += createTiquet();
                    System.out.println(comand);
                    System.out.println(ImportTally);
                    break;
                case 2:
                    if(comand.equals("")){
                        System.out.println("Primer has de crear la comanda");
                    }else {
                        comand += modifyTiquet();
                        System.out.println(comand);
                        System.out.println(ImportTally);
                    }
                    break;
                case 3:
                    if(comand.equals("")){
                        System.out.println("Primer has de crear la comanda");
                    }else {
                        System.out.println(comand);
                        System.out.println(ImportTally);
                    }
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Selecciona una opció vàlida");
                    break;
            }
            
        }while(!exit);
    }

    public String createTiquet(){

        String tiquet = "", name = "";
        String control = "s";

        System.out.println("Introdueix nom del client:");
        name = escaner.next();

        tiquet = "Client: " + name + "\n" + normalizeString("Producte", 20) + normalizeString("Quantitat", 20)+ normalizeString("Preu unitari", 20) + normalizeString("Subtotal", 20)+ "\n----------------------------------------------------------------------\n" ;

        while (control.equals("s")) {

            tiquet = tiquet + "\n" + addLine();
            System.out.println("Vols afegir algun producte més? (s/n)");
            control = escaner.next();

        } 
        ImportTally = createTally(totalImport);
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
        try{
            unitPrice = escaner.nextDouble();
        }catch(InputMismatchException e){
            System.out.println("Error: s'ha d'introduir un nombre");
        }
        System.out.println("");

        System.out.print("Quantitat: \t");
        try {
            productUnits = escaner.nextInt();
        }catch (InputMismatchException e) {
            System.out.println("Error: s'ha d'introduir un nombre enter");
        }
        System.out.println("");
        
        totalImport += unitPrice * productUnits;
        line = normalizeString(nameProduct, 20) + normalizeString(productUnits + "", 20) + normalizeString(df.format(unitPrice) + " €", 20) + normalizeString(df.format(unitPrice*productUnits) + " €", 20) + "\n";
        
        return line;
    }

    public String modifyTiquet() {
        String tiquet = "";
        String control = "s";
        
        while (control.equals("s")) {

            tiquet = tiquet + "\n" + addLine();
            System.out.println("Vols afegir algun producte més? (s/n)");
            control = escaner.next();

        }
        ImportTally = createTally(totalImport);
        return tiquet;
    }

    public String createTally(double finalImport) {
        String tallyString = "======================================================================\n";
        tallyString += normalizeString("Total sense IVA:", 60) + df.format(finalImport) + " € \n" + normalizeString("Iva (10%):", 60) + df.format((finalImport * 0.1)) + " € \n"+ normalizeString("TOTAL A PAGAR:", 60) + df.format((finalImport * 1.1)) + " €\n";
        return tallyString;
    }

    public String normalizeString(String str, int space) {
        String normalizedString = str;
        for(int i = str.length(); i < space; i++){
            normalizedString += " ";
        }
        return normalizedString;
    }
}
