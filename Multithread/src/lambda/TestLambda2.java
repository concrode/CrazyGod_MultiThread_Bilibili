package lambda;

public class TestLambda2 {

    static class Love2 implements ILove {
        @Override
        public void love(int a) {
            System.out.println("I love You-->" + a);
        }
    }

    public static void main(String[] args) {
        ILove love = new Love();
        love.love(1);

        love = new Love2();
        love.love(2);

        class Love3 implements ILove {
            @Override
            public void love(int a) {
                System.out.println("I love You-->" + a);
            }
        }

        love = new Love3();
        love.love(3);


        love = new ILove() {
            @Override
            public void love(int a) {
                System.out.println("I love You-->" + a);
            }
        };
        love.love(4);

        // lambda
        love = (int a) -> {
            System.out.println("I love You-->" + a);
        };
        love.love(5);


        // 1.Simply lambda
        love = (a) -> {
            System.out.println("I love You-->" + a);
        };
        love.love(6);


        // 2.Simply lambda
        love = a -> {
            System.out.println("I love You-->" + a);
        };
        love.love(7);


        // 3.Simply lambda
        love = a -> System.out.println("I love You-->" + a);
        love.love(8);
    }

}

/**
 * ======================= PAY ATTENTION:=========================
 * Interface has only one function that can be used lambda expression
 */
interface ILove {
    void love(int a);
}

class Love implements ILove {
    @Override
    public void love(int a) {
        System.out.println("I love You-->" + a);
    }
}