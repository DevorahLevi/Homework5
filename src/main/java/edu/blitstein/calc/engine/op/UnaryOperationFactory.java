package edu.blitstein.calc.engine.op;

import edu.blitstein.calc.exception.UnknownOpException;

public class UnaryOperationFactory
{
        public static UnaryOperation getOperator(String opType) throws UnknownOpException
        {
            UnaryOperation op = null;
            switch (opType)
            {
                case "abs":
                    op = UnaryOperation.ABSTRACT;
                    break;
                case "invert":
                    op = UnaryOperation.INVERT;
                    break;
                case "@":
                    op = UnaryOperation.OFF;
                    break;
                default:
                    throw new UnknownOpException(opType);
            }
            return op;
        }
}
