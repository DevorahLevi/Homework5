package edu.blitstein.calc.engine.op;

public enum UnaryOperation {
    ABSTRACT("abs") {
          public double apply(double x) {
            if (x < 0)
            {
                return (-x);
            }
            else { return x;}
          }
        },
    INVERT("invert"){
        public double apply(double x) {return 1/x;}
    },
    OFF("@"){
        public double apply(double x) {
            System.exit(0);
            return 0.0;
        }
    };

    private final String type;

    UnaryOperation(String type) {
      this.type = type;
    }

    @Override
    public String toString() {
      return type;
    }

    public abstract double apply(double x) throws ArithmeticException;
}