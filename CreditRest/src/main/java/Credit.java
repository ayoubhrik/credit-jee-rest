
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Credit {
	double capital,taux,annuite;
	int duree;
	
    public Credit() {
	}
	public Credit(double capital, double taux, double annuite, int duree) {
		super();
		this.capital = capital;
		this.taux = taux;
		this.annuite = annuite;
		this.duree = duree;
	}
	public double annuelle(double taux) {
		return Math.pow(1+taux, (double)1/12)-1;
	}
	public double annuite(double capital,double t ,int duree) {
		double taux = annuelle(t);
		return (Math.pow(1+taux,duree)*taux*capital)/(Math.pow(1+taux,duree)-1);
	}
	public double capital(double annuite,double t ,int duree) {
		double taux = annuelle(t);
		return (Math.pow(1+taux,duree)*annuite-annuite)/(Math.pow(1+taux,duree)*taux);
	}
	public int duree(double capital,double annuite ,double t) {
		double taux = annuelle(t);
		return (int) ((Math.log(annuite/(annuite-taux*capital))/Math.log(1+taux))+0.5);
	}
}