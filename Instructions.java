package aed.stackmachine;

import aed.lifo.*;

public class Instructions {

	static public class Add implements Instruction {
		public void execute(LIFO<Integer> stack) throws StackUnderFlowExc {
			if (stack.size() < 2) throw new StackUnderFlowExc();

			Integer value1 = stack.top();
			stack.pop();
			Integer value2 = stack.top();
			stack.pop();
			int result = value2 + value1;
			stack.push(result);
		}

		public String toString() {
			return "add";
		}
	}

	static public class Div implements Instruction {
		public void execute(LIFO<Integer> stack) throws StackUnderFlowExc {
			if (stack.size() < 2) throw new StackUnderFlowExc();

			Integer value1 = stack.top();
			stack.pop();

			if (value1 == 0) { 
				throw new ArithmeticException("Division by 0 is not allowed"); 
			}

			Integer value2 = stack.top();
			stack.pop();
			int result = value2 / value1;
			stack.push(result); 
		}

		public String toString() {
			return "div";
		}
	}

	static public class Power implements Instruction {
		public void execute(LIFO<Integer> stack) throws StackUnderFlowExc {
			if (stack.size() < 2) throw new StackUnderFlowExc();

			Integer value1 = stack.top();
			stack.pop();
			Integer value2 = stack.top();
			stack.pop();

			boolean is_negative = value1<0;
			value1 = Math.abs(value1);
			int result = 1;
			for (int i=1; i<=value1; i++)
			    result *= value2;
			if (is_negative)
			    stack.push(1/result);
			else
			    stack.push(result);
		}

		public String toString() {
			return "power";
		}
	}

	static public class Load implements Instruction {
		private int value; 

		public Load(int value) {
			this.value = value;
		}

		public void execute(LIFO<Integer> stack) throws StackUnderFlowExc {
			stack.push(value);
		}

		public String toString() {
			return "load("+value+")";
		}
	}

	static public class Drop implements Instruction {
		public void execute(LIFO<Integer> stack) throws StackUnderFlowExc {
			if (stack.size() < 1) throw new StackUnderFlowExc();

			//stack.top();
			stack.pop();
		}

		public String toString() {
			return "drop";
		}
	}

	static public class Dup implements Instruction {
		public void execute(LIFO<Integer> stack) throws StackUnderFlowExc {
			if (stack.size() < 1) throw new StackUnderFlowExc();

			Integer value = stack.top();
			stack.push(value);
		}

		public String toString() {
			return "dup";
		}
	}

	static public class Neg implements Instruction {
		public void execute(LIFO<Integer> stack) throws StackUnderFlowExc {
		    if (stack.size() < 1) throw new StackUnderFlowExc();

			Integer value = stack.top();
			stack.pop();
			stack.push(0-value);
		}

		public String toString() {
			return "neg";
		}
	}

	static public class Swap implements Instruction {
		public void execute(LIFO<Integer> stack) throws StackUnderFlowExc {
			if (stack.size() < 2) throw new StackUnderFlowExc();

			Integer value1 = stack.top();
			stack.pop();
			Integer value2 = stack.top();
			stack.pop();
			stack.push(value1);
			stack.push(value2);
		}

		public String toString() {
			return "swap";
		}
	}

}
