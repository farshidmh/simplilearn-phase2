import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;One
One
@Entity
@Table(name="tbl_desk")
public class Desk {
	
	
	@Id @GeneratedValue
	@Column(name="desk_id")
	private int deskId;
	
	
	@Column(name="name")
	private String name;
	
	
	@Column(name="color")
	private String color;


	@ManyToOne(cascade=CascadeType.ALL)
	private Employee emp;

	
	
	public Desk() {
		super();
	}



	public Desk(int deskId, String name, String color) {
		super();
		this.deskId = deskId;
		this.name = name;
		this.color = color;
	}


	

	public Employee getEmp() {
		return emp;
	}



	public void setEmp(Employee emp) {
		this.emp = emp;
	}



	public int getDeskId() {
		return deskId;
	}



	public void setDeskId(int deskId) {
		this.deskId = deskId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getColor() {
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}
	
	
	

	
	
	
	
	
	
	
}
