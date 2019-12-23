package jp.ac.uryukyu.ie.e195753;

/**
 * 生き物クラス。
 * 主にHeroクラスやEnemyクラスに拡張して使用する。
 *  String name; //名前
 *  int hitPoint; //HP
 *  int attack; //攻撃力
 *  boolean dead; //生死状態。true=死亡。
 * Created by e195753.
 */

public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;
    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name 名前
     * @param maximumHP HP
     * @param attack 攻撃力
     */
    public LivingThing (String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }
    /**
     * 生死確認メソッド
     * @return dead 生死状態(true=死亡)
     */
    public boolean isDead(){
        return dead;
    }
    /**
     * 生死設定メソッド
     * @param dead 生死状態(true=死亡)
     */
    public void setDead(boolean dead){
        this.dead = dead;
    }
    /**
     * 名前のgetter
     * @return name 名前
     */
    public String getName(){
        return name;
    }
    /**
     * 名前のsetter
     * @param name 名前
     */
    public  void setName(String name){
        this.name = name;
    }
    /**
     * HPのgetter
     * @return hitPoint HP
     */
    public  int getHitPoint(){
        return hitPoint;
    }
    /**
     * HPのsetter
     * @param hitPoint HP
     */
    public void setHitPoint(int hitPoint){

        this.hitPoint = hitPoint;
    }
    /**
     * 攻撃力のgetter
     * @return name 攻撃力
     */
    public  int getAttack(){
        return this.attack;
    }
    /**
     * 攻撃力のsetter
     * @param attack 攻撃力
     */
    public  void  setAttack(int attack){
        this.attack = attack;
    }
    /**
     * 自身が攻撃したときのダメージ処理をするメソッド。
     * 攻撃力に乱数を欠けて暫定ダメージをだし、woundedに投げる
     * @param livingthing 攻撃する相手
     */
    public void attack(LivingThing livingthing) {
        if (!this.isDead()) {
            int damage = (int) (Math.random() * getAttack());
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", getName(), livingthing.getName(), damage);
            livingthing.wounded(damage);
        }
    }
    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }
    }
}
