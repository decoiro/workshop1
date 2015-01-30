package biz.netcentric.apushop;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by dario on 30/01/15.
 */
public class Caixeiro {

    public static final int CHERRY_DISCOUNT = 20;
    public static final String CHERRY = "cherry";
    public static final String APPLE = "apple";
    public static final String BANANA = "banana";
    static Map<String, Integer> listaDaCompra;

    static Map<String, Integer> contas;

    static {
        listaDaCompra = new HashMap<String, Integer>(3);
        listaDaCompra.put("apple", 100);
        listaDaCompra.put("cherry", 75);
        listaDaCompra.put("banana", 150);

        contas = new Hashtable<String, Integer>(3);
        contas.put("apple", 0);
        contas.put("cherry", 0);
        contas.put("banana", 0);
    }
    int suma;

    public int ponmeOutra(String queCaralloQueres){
        String key = revisarSinonimos(queCaralloQueres);
        Integer valor = listaDaCompra.get(key);
        if(valor != null){
            contas.put(key, contas.get(key)+1);
        }

        return getTotal();
    }

    private String revisarSinonimos(String queCaralloQueres) {
        switch (queCaralloQueres) {
        case "manzana":
            return APPLE;
        case "apfle":
            return APPLE;
        default:
            return queCaralloQueres;
        }
    }

    private int getTotal(){
        int numeroDeCereixas = contas.get(CHERRY);
        int numeroDeBananas = contas.get(BANANA);
        int res = 0;
        res += contas.get(APPLE)*listaDaCompra.get(APPLE);
        res += numeroDeBananas*listaDaCompra.get(BANANA);
        res += numeroDeCereixas*listaDaCompra.get(CHERRY);

        int desconto = calculoDescontoCereixas(numeroDeCereixas);
        desconto += calculoDescontoBananas(numeroDeBananas);


        return res-desconto;
    }

    private int calculoDescontoBananas(int numeroDeBananas) {
        return ((int)Math.ceil(numeroDeBananas/2))* listaDaCompra.get(BANANA);
    }

    private int calculoDescontoCereixas(int numeroDeCereixas) {
        return ((int)Math.ceil(numeroDeCereixas/2))* CHERRY_DISCOUNT;
    }
}
