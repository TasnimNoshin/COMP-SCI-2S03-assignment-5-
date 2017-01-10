package cs2s03;

class Integer2 extends Expr {
	  int i;

	  Integer2(int x) { i = x; }
	  public String toString() { return Integer.toString(i) ; }
	  public boolean isGround() { return true; }
	  
	  @Override
	  public int evalToInt() throws NotAnInteger{
		  int ansI = (int)(i);
		  float ansF = (float) (i);
		  if (ansI != ansF) throw new NotAnInteger("not an Integer.");
		  return ansI;
	  }
	  
	  @Override
	  public float evalToFloat (){
		  float ans = (float)(i);
		  return ans;
	  }
	}
