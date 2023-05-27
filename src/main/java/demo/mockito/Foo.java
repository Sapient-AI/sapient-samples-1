package demo.mockito;


public class Foo {


    public void example(int a, int b, int a1, int b1, int c, int d, int a2, int b2, int e, int f, int n, int h,int z) {
        if (a == b) {
            if (a1 == b1) {
                fiddle();
            } else if (a2 == b2) {
                fiddle();
            } else {
                fiddle();
            }
        } else if (c == d) {
            while (c == d) {
                fiddle();
                if (c>0) {
                    return;
                }
            }
        } else if (e == f) {
            for (n = 0; n < h; n++) {
                fiddle();
            }
        } else {
            switch (z) {
                case 1:
                    fiddle();
                    break;
                case 2:
                    fiddle();
                    break;
                case 3:
                    fiddle();
                    break;
                default:
                    fiddle();
                    break;
            }
        }
    }

    private void fiddle() {

    }

}