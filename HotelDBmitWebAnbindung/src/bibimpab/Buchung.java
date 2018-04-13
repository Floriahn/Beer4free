package bibimpab;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Buchung {

	private String id;
	private String gid;
	private String zid;
	private String von;
	private String bis;
	private int anz;
	private boolean bezahlt;
	
	private String insert = "INSERT INTO buchung (zid, gid, von, bis, anz, bezahlt) VALUES(?, ?, ?, ?, ?, ?)";
	
	public Buchung(Gast gast, Zimmer zimmer, String von, String bis, int anz, boolean bezahlt){
		gid = gast.getId();
		zid = zimmer.getId();
		this.von = von;
		this.bis = bis;
		this.anz = anz;
		this.bezahlt=bezahlt;
	}
	
	public String getInsertString(){
		return insert;
	}
	
	public String getId() {
		return id;
	}
	public String getGid() {
		return gid;
	}
	public String getZid() {
		return zid;
	}
	public Date getVon() {
		String sDat = von;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date;
		try {
			date = sdf.parse(sDat);
			java.sql.Date sqldate = new java.sql.Date(date.getTime());
			return sqldate;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	public Date getBis() {
		String sDat = bis;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date;
		try {
			date = sdf.parse(sDat);
			java.sql.Date sqldate = new java.sql.Date(date.getTime());
			return sqldate;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	public String getVonStr(){
		return von;
	}
	public String getBisStr(){
		return bis;
	}
	public int getAnz() {
		return anz;
	}
	public boolean isBezahlt() {
		return bezahlt;
	}
	public void setVon(String von) {
		this.von = von;
	}
	public void setBis(String bis) {
		this.bis = bis;
	}
	public void setAnz(int anz) {
		this.anz = anz;
	}
	public void setBezahlt(boolean bezahlt) {
		this.bezahlt = bezahlt;
	}
	public void setId(String x){
		this.id=x;
	}
	
}
