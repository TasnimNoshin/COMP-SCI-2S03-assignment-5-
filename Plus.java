package cs2s03;

class Plus extends BinaryOp {
	  Plus(Expr x, Expr y) { left = x; right = y; }
	  public String toString() { 
	    // we are the context
	    return super.toString(this, " + "); }
	  public boolean isSame(Expr e) { return e instanceof Plus; }
	  
	  @Override
	  public int evalToInt() throws NotAnInteger{
		  int ansI = left.evalToInt() + right.evalToInt();
		  float ansF = left.evalToFloat() + right.evalToFloat();
		  if (ansI != ansF) throw new NotAnInteger("not an Integer.");
		  return ansI;
	  }
	  
	  @Override
	  public float evalToFloat() {
		  float ans = left.evalToFloat() + right.evalToFloat();
		  return ans;
	  }
	}

