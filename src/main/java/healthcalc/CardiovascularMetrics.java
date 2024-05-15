package healthcalc;

public class CardiovascularMetrics {


    public double getIdealBodyWeight(Paciente p){
        double idealW = 0;

        if(p.height()<=0){
            throw new RuntimeException("Altura introducida no valida: es menor o igual que 0");
        }else{
            switch (p.gender()) {
                case FEMALE:
                    idealW = p.height() - 100 - (p.height() - 150) / 2.5f;
                    break;
                case MALE:
                    idealW = p.height() - 100 - (p.height() - 150) / 4;
                    break;
                default:
                    throw new RuntimeException("Género introducido no válido");
        }
        }

        return idealW;
    }
}
