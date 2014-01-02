package api_perso;

import java.util.*;

public class DateModifiable implements Comparable<Object>, Cloneable {
  
        private GregorianCalendar c = new GregorianCalendar();
        private int	nbJoursDepuisDerniereMAJ  = 0;

        private DateModifiable(Date d) {
                c.setTime(d);	// date du jour
        }

        //----------- constructeurs publics --------

        public DateModifiable(String vInit) { // a la francaise
                affecteUniquementC(vInit);
        }

        public DateModifiable() {
                this(new Date());	// date du jour
        }

        //----------- modificateurs publics --------

        public void modifieToi(String nouvV) {
                int j1 = c.get(Calendar.DAY_OF_YEAR);
                int a1 = c.get(Calendar.YEAR);
                affecteUniquementC(nouvV);
                int j2 = c.get(Calendar.DAY_OF_YEAR);
                int a2 = c.get(Calendar.YEAR);
                nbJoursDepuisDerniereMAJ = (j2-j1)+(a2-a1)*365;
        }


        public void plusNombreJours(int n) {
                c.add(Calendar.DAY_OF_YEAR,n);
                nbJoursDepuisDerniereMAJ  = n;
        }


        //----------- selecteurs publics libres --------

        public boolean avant(DateModifiable autre) {
                return compareTo(autre)<0;
        }



        public int nbJoursDepuisDerniereMAJ() {
                return nbJoursDepuisDerniereMAJ;
        }


        //----------- selecteurs publics imposes --------

        public String toString() {
            StringTokenizer st =
                    new StringTokenizer(c.getTime().toString()," ") ;
            String[] s = new String[6];
            int i;
            for (i=0;i<6;i++)
                    s[i]=st.nextToken();
            return  s[2]+ ' '+ s[1] + ' ' + s[5];
        	
        	/*return c.getTime().toString();*/
    }



        public Object clone() throws CloneNotSupportedException {
                                     //remplace DateModifiable(DateModifiable)
                DateModifiable copie = (DateModifiable) super.clone();
                copie.c = (GregorianCalendar) c.clone();
                return copie;
        }


        public int compareTo(Object o) { // unique methode de Comnparable
                DateModifiable autre = (DateModifiable) o;
                int anneeThis  = c.get(Calendar.YEAR);
                int anneeAutre = autre.c.get(Calendar.YEAR);
                int res;
                if (anneeThis==anneeAutre)
                    res = c.get(Calendar.DAY_OF_YEAR)-autre.c.get(Calendar.DAY_OF_YEAR);
                else
                        res = anneeThis - anneeAutre;
                return res;
        }

        public boolean equals(DateModifiable autre) {
                return compareTo(autre)==0;
        }

        //----------- modificateurs prives --------

        private void affecteUniquementC(String nouvV) {
                StringTokenizer st = new StringTokenizer(nouvV,"/") ;
                int jj = Integer.parseInt(st.nextToken());
                int mm = Integer.parseInt(st.nextToken());
                int aa = Integer.parseInt(st.nextToken());
                c.set(aa,mm-1,jj);			// 2eme param dans [0,11]
        }


        //----------- constructeur prive --------

        /*private DateModifiable(DateModifiable dM) {
                this(dM.c.getTime());
        }*/


}