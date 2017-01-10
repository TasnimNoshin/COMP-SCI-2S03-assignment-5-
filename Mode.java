package cs2s03;

public enum Mode {INTEGER,FLOAT}

abstract class Value {
	Mode m;
}


class IntVal extends Value {
	int val;
	public int getVal(){return val;}

}

class DblVal extends Value{
	double val;
	public double getVal(){return val;}
}
