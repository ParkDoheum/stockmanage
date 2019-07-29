package hrd;

public class ProductVo {
	private int p_no, p_cnt_sum, p_cnt_rem, p_price, i_cnt;
	private int i_no, typ;
	private String p_name, i_date;
		

	public int getI_no() {
		return i_no;
	}
	public void setI_no(int i_no) {
		this.i_no = i_no;
	}
	public String getI_date() {
		return i_date;
	}
	public void setI_date(String i_date) {
		this.i_date = i_date;
	}
	public int getTyp() {
		return typ;
	}
	public void setTyp(int typ) {
		this.typ = typ;
	}
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
