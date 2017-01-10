package cs2s03;

//import java.lang.ArithmeticException;

class Divide extends Expr { // NOT BinaryOp!
	  Expr left;
	  Expr right;
	  Divide(Expr x, Expr y) { left = x; right = y; }
	  public String toString() { 
	    return betweenParens(left) + " / " + betweenParens(right); }
	  public boolean isGround() { return false; }
	  
	  @Override
	  public int evalToInt() throws NotAnInteger{
		  if (right.evalToInt() == 0) ;
		  int ansI = left.evalToInt() / right.evalToInt();
		  float ansF = left.evalToFloat() / right.evalToFloat();
		  if (ansI != ansF)  throw new NotAnInteger("not an Integer.");
		  return ansI;
	  }
	  
	  @Override
	  public float evalToFloat() {
		  float ans = left.evalToFloat() / right.evalToFloat();
		  return ans;
	  }
	}


