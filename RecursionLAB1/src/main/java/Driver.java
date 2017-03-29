public class Driver {

    public static void main(String[] args) {
        // int n = 30;

       /* RecursivePascal r = new RecursivePascal();
        r.triangleUp = false;
        r.printPascal(n); */

       /* RecursivePascalImproved i = new RecursivePascalImproved();
        i.triangleUp=false;
        i.printPascal(n); */

      IterativePascal p = new IterativePascal();
        p.triangleUp=false;
        p.n = 10;
        p.arrayN = new int[p.n][p.n];
        p.printPascal(p.n);

    }
}

