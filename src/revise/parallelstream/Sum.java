package revise.parallelstream;

public class Sum {
	private Integer total = 0;

	public void performAdd(Integer val) {
		total += val;
	}

	public Integer getValue() {
		return total;
	}
}
