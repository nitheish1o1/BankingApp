package com.mypack;

public interface Stratergy {
    void do_transaction(int rs) throws Exception;
}

class  Deposit implements Stratergy{

    @Override
    public void do_transaction(int rs) throws Exception {
            Generate_log mylog1 = Generate_log.getInstance();
            mylog1.update_log("direct deposit RS: "+rs+"\n");
    }
}

class Withdraw implements Stratergy{

    @Override
    public void do_transaction(int rs) throws Exception {
        Generate_log mylog2 = Generate_log.getInstance();
        mylog2.update_log("direct withdraw RS: "+rs+"\n");
    }
}

class Send implements Stratergy{

    @Override
    public void do_transaction(int rs) throws Exception {
        Generate_log mylog3 = Generate_log.getInstance();
        mylog3.update_log("sent to ***  RS: "+rs+"\n");
    }
}

class Receive implements Stratergy{

    @Override
    public void do_transaction(int rs) throws Exception {
        Generate_log mylog4 = Generate_log.getInstance();
        mylog4.update_log("received from *** RS: "+rs+"\n");
    }
}

class Context{
    private final Stratergy stratergy;
    public Context(Stratergy stratergy){
        this.stratergy = stratergy;
    }
    public void execute_stratergy(int rs) throws Exception {
        stratergy.do_transaction(rs);
    }
}

