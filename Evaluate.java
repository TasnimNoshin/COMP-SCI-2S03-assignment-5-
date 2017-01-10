package cs2s03;

public class Evaluate {
	private Expr e;
	private Mode m;

	Evaluate(String s, Mode m) throws ParseError{
		Parser p = new Parser(s);
		this.e = p.parse();
		this.m = m;
	}
	public Value eval() throws NotAnInteger{
		if (m == Mode.INTEGER) {
			IntVal ie = new IntVal();
			ie.m = m;
			ie.val = e.evalToInt();
			return ie;

		} else {
			DblVal fe = new DblVal();
			fe.m = m;
			fe.val = e.evalToFloat();
			return fe;
		}

	}
}
