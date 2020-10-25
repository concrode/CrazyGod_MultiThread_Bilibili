package lambda;

public class TestLambda1 {

    // 2.Static inner class
    static class Like2 implements ILike {
        @Override
        public void lambda() {
            System.out.println("I like lambda2");
        }
    }


    public static void main(String[] args) {
        ILike like = new Like();
        like.lambda();

        like = new Like2();
        like.lambda();

        // 3.Local Inner class
        class Like3 implements ILike {
            @Override
            public void lambda() {
                System.out.println("I like lambda3");
            }
        }

        like = new Like3();
        like.lambda();

        // 4.Anonymous Inner class. Implement interface ILike()
        like = new ILike() {
            @Override
            public void lambda() {
                System.out.println("I like lambda4");
            }
        };
        like.lambda();

        // 5.Using lambda
        like = () -> {
            System.out.println("I like lambda5");
        };
        like.lambda();

    }
}

/**
 *  * ======================= PAY ATTENTION:=========================
 *  * Interface has only one function can be used lambda expression
 **/
interface ILike {
    void lambda();
}

/**
 *  1.Inner class
 */
class Like implements ILike {
    @Override
    public void lambda() {
        System.out.println("I like lambda1");
    }
}