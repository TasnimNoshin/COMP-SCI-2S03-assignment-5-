package cs2s03;

import static org.junit.Assert.*;

import org.junit.Test;

public class TesterClass {

	@Test
	public void testExpr() throws NotAnInteger{

		//test for Plus
		Expr testP1 = new Plus (new Integer2(4), new Integer2(7));
		assertEquals(testP1.evalToInt(),11);
		assertEquals(testP1.evalToFloat(),11.0,0.000001);
		//test for Plus
		Expr testP2 = new Plus (new Integer2(17), new Integer2(8));
		assertEquals(testP2.evalToInt(),25);
		assertEquals(testP2.evalToFloat(),25.0,0.000001);

		//test for Minus
		Expr testM1 = new Minus (new Integer2(9), new Integer2(7));
		assertEquals(testM1.evalToInt(),2);
		assertEquals(testM1.evalToFloat(),2.0,0.000001);
		//test for Minus
		Expr testM2 = new Minus (new Integer2(8), new Integer2(13));
		assertEquals(testM2.evalToInt(),-5);
		assertEquals(testM2.evalToFloat(),-5.0,0.000001);

		//test for Times
		Expr testT1 = new Times (new Integer2(-9), new Integer2(5));
		assertEquals(testT1.evalToInt(),-45);
		assertEquals(testT1.evalToFloat(),-45.0,0.000001);
		//test for Times
		Expr testT2 = new Times (new Integer2(12), new Integer2(14));
		assertEquals(testT2.evalToInt(),168);
		assertEquals(testT2.evalToFloat(),168.0,0.000001);

		//test for Divide
		Expr testD1 = new Divide (new Integer2(-9), new Integer2(3));
		assertEquals(testD1.evalToInt(),-3);
		assertEquals(testD1.evalToFloat(),-3.0,0.000001);
		//test for Times
		Expr testD2 = new Divide (new Integer2(12), new Integer2(4));
		assertEquals(testD2.evalToInt(),3);
		assertEquals(testD2.evalToFloat(),3.0,0.000001);

		//test for UnaryMinus
		Expr testU1 = new UnaryMinus (new Integer2(6));
		assertEquals(testU1.evalToInt(),-6);
		assertEquals(testU1.evalToFloat(),-6.0,0.000001);
		//test for UnaryMinus
		Expr testU2 = new UnaryMinus (new Integer2(-11));
		assertEquals(testU2.evalToInt(),11);
		assertEquals(testU2.evalToFloat(),11.0,0.000001);

		//test for random mixed tests
		Expr testR1 = new Divide (new Plus(new Integer2(9),new Integer2(6)),new UnaryMinus(new Integer2(3)));
		assertEquals(testR1.evalToInt(),-5);
		assertEquals(testR1.evalToFloat(),-5.0,0.000001);

		Expr testR2 = new Times (new Minus(new Integer2(44),new Integer2(30)),new Integer2(7));
		assertEquals(testR2.evalToInt(),98);
		assertEquals(testR2.evalToFloat(),98.0,0.000001);

		Expr testR3 = new Times (new Divide(new Integer2(120),new Integer2(60)),new UnaryMinus(new Integer2(4)));
		assertEquals(testR3.evalToInt(),-8);
		assertEquals(testR3.evalToFloat(),-8.0,0.000001);
	}

	@Test
	public void TestEval() throws ParseError, NotAnInteger {

		String Str;
		Evaluate evali;
		Evaluate evalf;
		IntVal ival;
		DblVal dval ;

		//test for Plus
		Str = "100+233";
		evali = new Evaluate(Str,Mode.INTEGER);
		ival = (IntVal) evali.eval();
		assertEquals(ival.val, 333);
		evalf = new Evaluate(Str,Mode.FLOAT);
		dval = (DblVal)evalf.eval();
		assertEquals(dval.val, 333.0,0.000001);

		//test for Minus
		Str = "355-245";
		evali = new Evaluate(Str,Mode.INTEGER);
		ival = (IntVal) evali.eval();
		assertEquals(ival.val, 110);
		evalf = new Evaluate(Str,Mode.FLOAT);
		dval = (DblVal)evalf.eval();
		assertEquals(dval.val, 110.0,0.000001);

		//test for Times
		Str = "9*8";
		evali = new Evaluate(Str,Mode.INTEGER);
		ival = (IntVal) evali.eval();
		assertEquals(ival.val, 72);
		evalf = new Evaluate(Str,Mode.FLOAT);
		dval = (DblVal)evalf.eval();
		assertEquals(dval.val, 72.0,0.000001);

		//test for Divide
		Str = "50/10";
		evali = new Evaluate(Str,Mode.INTEGER);
		ival = (IntVal) evali.eval();
		assertEquals(ival.val, 5);
		Str = "2/3";
		evalf = new Evaluate(Str,Mode.FLOAT);
		dval = (DblVal)evalf.eval();
		assertEquals(dval.val, 0.6666667,0.000001);

		//test for Random
		Str = "30+(20/4)-(3*2)-4";
		evali = new Evaluate(Str,Mode.INTEGER);
		ival = (IntVal) evali.eval();
		assertEquals(ival.val, 25);
		evalf = new Evaluate(Str,Mode.FLOAT);
		dval = (DblVal)evalf.eval();
		assertEquals(dval.val, 25.0,0.000001);

	}

	//test for ParseErrors

	@Test(expected = ParseError.class)
	public void TestParser1() throws ParseError,NotAnInteger{
		Parser par = new Parser("p*31");
		par.parse();
	}

	@Test(expected = ParseError.class)
	public void TestParser2() throws ParseError,NotAnInteger{
		Parser par = new Parser("a.4");
		par.parse();
	}

	//test for NotAnInteger

	@Test(expected = NotAnInteger.class)
	public void TestNotInt1() throws NotAnInteger{
		Expr e = new Divide(new Integer2 (5) , new Integer2(13));
		e.evalToInt();
	}

	@Test(expected = NotAnInteger.class)
	public void TestNotInt2() throws NotAnInteger{
		Expr e = new Divide(new Times (new Integer2(4),new Integer2(3)) , new Minus(new Integer2(7), new Plus (new Integer2(1),new Integer2(1))));
		e.evalToInt();
	}

}
