package cs2s03;

class UnaryMinus extends Expr {
	  Expr e;

	  UnaryMinus(Expr x) { e = x; }
	  public String toString() { return "-" + e.toString(); }
	  public boolean isGround() { return false; }
	  
	  @Override
	  public int evalToInt() throws NotAnInteger{
		  int ansI = -1*(e.evalToInt());
		  float ansF = -1*(e.evalToFloat());
		  if (ansI != ansF) throw new NotAnInteger("not an Integer.");
		  return ansI;
	  }
	  
	  @Override
	  public float evalToFloat() {
		  float ans = -1*(e.evalToFloat());
		  return ans;
	  }
	}
