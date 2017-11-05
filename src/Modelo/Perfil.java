/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author davis
 */
public class Perfil {
    
    //5 big
    private double apertura_experiencias;
    final int min_ap_exp = 50;
    
    private double responsabilidad;
    final int min_resp = 30;
    
    private double extroversion;
    final int min_extro = 35;
    
    private double amabilidad;
    final int min_amab = 60;
    
    private double rango_emocional;
    final int min_ran_emo = 30;
    //necesidades
    private double desafio;
    final int min_desa = 45;
    
    private double curiosidad;
    final int min_curio = 45;
    
    private double entusiasmo;
    final int min_ent = 40;
    
    private double ideal;
    final int min_ideal = 50;
            
    private double autoexpresion;
    final int min_autoexp = 35;
    
    private double estabilidad;
    final int min_estab = 50;
    //valores
    private double superacion_personal;
    final int min_sup_per = 55;
    
    public double suma;
    final double valorInsight = 0.083333;

    public Perfil(double apertura_experiencias, double responsabilidad, double extroversion, double amabilidad, double rango_emocional, double desafio, double curiosidad, double entusiasmo, double ideal, double autoexpresion, double estabilidad, double superacion_personal) {
        this.apertura_experiencias = apertura_experiencias;
        this.responsabilidad = responsabilidad;
        this.extroversion = extroversion;
        this.amabilidad = amabilidad;
        this.rango_emocional = rango_emocional;
        this.desafio = desafio;
        this.curiosidad = curiosidad;
        this.entusiasmo = entusiasmo;
        this.ideal = ideal;
        this.autoexpresion = autoexpresion;
        this.estabilidad = estabilidad;
        this.superacion_personal = superacion_personal;
        this.suma = 0;
    }

    @Override
    public String toString() {
        return "Perfil{" + "apertura_experiencias=" + apertura_experiencias + ", min_ap_exp=" + min_ap_exp + ", responsabilidad=" + responsabilidad + ", min_resp=" + min_resp + ", extroversion=" + extroversion + ", min_extro=" + min_extro + ", amabilidad=" + amabilidad + ", min_amab=" + min_amab + ", rango_emocional=" + rango_emocional + ", min_ran_emo=" + min_ran_emo + ", desafio=" + desafio + ", min_desa=" + min_desa + ", curiosidad=" + curiosidad + ", min_curio=" + min_curio + ", entusiasmo=" + entusiasmo + ", min_ent=" + min_ent + ", ideal=" + ideal + ", min_ideal=" + min_ideal + ", autoexpresion=" + autoexpresion + ", min_autoexp=" + min_autoexp + ", estabilidad=" + estabilidad + ", min_estab=" + min_estab + ", superacion_personal=" + superacion_personal + ", min_sup_per=" + min_sup_per + ", suma=" + suma + ", valorInsight=" + valorInsight + '}';
    }

    
    
    //Se evalúa el perfil y se devuelve la suma
    public double getResultado(){
        
        this.addValor(this.apertura_experiencias, this.min_ap_exp);
        this.addValor(this.responsabilidad, this.min_resp);
        this.addValor(this.extroversion, this.min_extro);
        this.addValor(this.amabilidad, this.min_amab);
        this.addValor(this.rango_emocional, this.min_ran_emo);
        this.addValor(this.desafio, this.min_desa);
        this.addValor(this.curiosidad, this.min_curio);
        this.addValor(this.entusiasmo, this.min_ent);
        this.addValor(this.ideal, this.min_ideal);
        this.addValor(this.autoexpresion, this.min_autoexp);
        this.addValor(this.estabilidad, this.min_estab);
        this.addValor(this.superacion_personal, this.min_sup_per);
        
        double resultado = this.suma;

        return resultado;
    }
    
    //se agrega un valor a la probabilidad de deserción si es necesario
    public void addValor(double insight, float min){
        if((float)insight*100 < min){
            this.suma = this.suma + this.valorInsight;
        }
        //System.out.println(insight*100 + " " + min + " " + this.suma + " " + this.valorInsight);

    }

    public double getApertura_experiencias() {
        return apertura_experiencias;
    }

    public void setApertura_experiencias(double apertura_experiencias) {
        this.apertura_experiencias = apertura_experiencias;
    }

    public double getResponsabilidad() {
        return responsabilidad;
    }

    public void setResponsabilidad(double responsabilidad) {
        this.responsabilidad = responsabilidad;
    }

    public double getExtroversion() {
        return extroversion;
    }

    public void setExtroversion(double extroversion) {
        this.extroversion = extroversion;
    }

    public double getAmabilidad() {
        return amabilidad;
    }

    public void setAmabilidad(double amabilidad) {
        this.amabilidad = amabilidad;
    }

    public double getRango_emocional() {
        return rango_emocional;
    }

    public void setRango_emocional(double rango_emocional) {
        this.rango_emocional = rango_emocional;
    }

    public double getDesafio() {
        return desafio;
    }

    public void setDesafio(double desafio) {
        this.desafio = desafio;
    }

    public double getCuriosidad() {
        return curiosidad;
    }

    public void setCuriosidad(double curiosidad) {
        this.curiosidad = curiosidad;
    }

    public double getEntusiasmo() {
        return entusiasmo;
    }

    public void setEntusiasmo(double entusiasmo) {
        this.entusiasmo = entusiasmo;
    }

    public double getIdeal() {
        return ideal;
    }

    public void setIdeal(double ideal) {
        this.ideal = ideal;
    }

    public double getAutoexpresion() {
        return autoexpresion;
    }

    public void setAutoexpresion(double autoexpresion) {
        this.autoexpresion = autoexpresion;
    }

    public double getEstabilidad() {
        return estabilidad;
    }

    public void setEstabilidad(double estabilidad) {
        this.estabilidad = estabilidad;
    }

    public double getSuperacion_personal() {
        return superacion_personal;
    }

    public void setSuperacion_personal(double superacion_personal) {
        this.superacion_personal = superacion_personal;
    }

    public double getSuma() {
        return suma;
    }

    public void setSuma(double suma) {
        this.suma = suma;
    }

    
    
}
