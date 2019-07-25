package hrd;

public class ProductVo {
	private int p_no, p_cnt_sum, p_cnt_rem, p_price, i_cnt;
	private String p_name;
		
	public int getI_cnt() {
		return i_cnt;
	}
	public void setI_cnt(int i_cnt) {
		this.i_cnt = i_cnt;
	}
	public int getP_no() {
		return p_no;
	}
	public void setP_no(int p_no) {
		this.p_no = p_no;
	}
	public int getP_cnt_sum() {
		return p_cnt_sum;
	}
	public void setP_cnt_sum(int p_cnt_sum) {
		this.p_cnt_sum = p_cnt_sum;
	}
	public int getP_cnt_rem() {
		return p_cnt_rem;
	}
	public void setP_cnt_rem(int p_cnt_rem) {
		this.p_cnt_rem = p_cnt_rem;
	}
	public int getP_price() {
		return p_price;
	}
	public void setP_price(int p_price) {
		this.p_price = p_price;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
}
