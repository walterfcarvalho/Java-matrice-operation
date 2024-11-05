public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("");
        System.out.println("\r\n");
        System.out.println("\r\n");
     
        Matrice A = new Matrice("2,2,2;2,2,2");
     
        Matrice B = new Matrice("1,1,1;1,1,1");
        
        Matrice C = new Matrice("3,4;1,2");
        Matrice D = new Matrice("3,3,3;3,3,3");
                
        System.out.println("A: " + A.toString());
        System.out.println("B: " + B.toString());
        
        System.out.println("A + B: " + A.plus(B));
        System.out.println("A - B: " + A.minus(B));
        
        System.out.println("C: " + C.toString());
        System.out.println("D: " + D.toString());
        System.out.println("C x D: " + C.times(D));
    }
}
