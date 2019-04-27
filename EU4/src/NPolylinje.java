import java.util.Iterator;

public class NPolylinje implements Polylinje{
	
		private static class Nod
		 {
			 public Punkt horn;
			 public Nod nastaNod;
			 
			 public Nod (Punkt horn){
				 this.horn = horn;
				 nastaNod = null;
				 }
			 }
		
		 private Nod horn;
		 private String farg = "svart";
		 private int bredd = 1;
		 
		 public NPolylinje (){
			 this.horn = null;
			 }
		 
		 public NPolylinje (Punkt[] horn)
		 {
			 if (horn.length > 0){
				 Nod nod = new Nod (new Punkt (horn[0]));
				 this.horn = nod;
				 int pos = 1;
				 while (pos < horn.length)
				 {
					 nod.nastaNod = new Nod (new Punkt (horn[pos++]));
					 nod = nod.nastaNod;
				}
			}
		 }
		 
		 public Punkt[] getHorn() {
				return null;
			}

			public String getFarg() {
				return this.farg;
			}

			public int getBredd() {
				return this.bredd;
			}

			public double langd() {
				 double langden = 0;
				 Nod current = this.horn;
				 while(current.nastaNod != null) {
						langden += current.horn.avstand(current.nastaNod.horn);
						current = current.nastaNod;
					}
			        return langden;
			}

			public void setFarg(String farg) {
				this.farg = farg;
			}
			
			public void setBredd(int bredd) {
				this.bredd = bredd;
			}

		
			public void laggTill(Punkt horn) {
				if(this.horn == null) {
					this.horn = new Nod(horn);
				}
				Nod current = this.horn;
				while(current.nastaNod != null) {
					current = current.nastaNod;
				}
				current.nastaNod = new Nod(horn);
			}

			public void laggTillFramfor(Punkt horn, String hornNamn) {
				Nod current = this.horn;
				Nod newNod = new Nod(horn);
				if(current.horn.getNamn().equals(hornNamn)) {
					newNod.nastaNod = current;
					this.horn = newNod;
					return;
				}
				
				while(!current.nastaNod.horn.getNamn().equals(hornNamn)){
					current = current.nastaNod;
				}
				newNod.nastaNod = current.nastaNod;
				current.nastaNod = newNod;
			}

			public void taBort(String hornNamn) {
				Nod current = this.horn;
				if(current.horn.getNamn().equals(hornNamn)) {
					this.horn = current.nastaNod;
					return;
				}
				
				while(!current.nastaNod.horn.getNamn().equals(hornNamn)){
					current = current.nastaNod;
				}
				
				if(current.nastaNod.nastaNod != null) {
					current.nastaNod = current.nastaNod.nastaNod;
				} else {
					current.nastaNod = null;
				}
			}
			
			public Iterator <Punkt> iterator() {
				return new Iterator<Punkt>() {
					Nod current = NPolylinje.this.horn;
					public boolean hasNext() {
						return current != null;
					}
					
					public Punkt next() {
						Nod n = current;
						current = current.nastaNod;
						return n.horn;
					}
				};
			}

			
			public String toString()
			{
				StringBuilder sBuilder = new StringBuilder();
				sBuilder.append("{");
				Nod current = this.horn;
				while(current != null) {
					sBuilder.append(current.horn.toString());
					current = current.nastaNod;
				}
				sBuilder.append(", " + this.farg + ", " + this.langd());
				sBuilder.append("}");
				
		return sBuilder.toString(); 
		}

}
