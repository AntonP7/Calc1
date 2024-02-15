import java.text.DecimalFormat;
public enum OperationCalc {
    NONE ("nothing"){
        public String OperCalc(int arg1, int arg2) {
            return ""+0;
        }

    }, SUM ("slozhenie") {
        @Override
        public String OperCalc(int arg1, int arg2) {
            return (""+ arg1 + arg2);
        }
    }, DIV ("delenie") {
        @Override
        public String OperCalc(int arg1, int arg2  ) {

            if (arg1 / arg2 % 2 != 0 ) {
                return (""+(float) arg1/arg2);
            }
            else if (arg1 / arg2 % 1 == 0) {
                return ("" + (float) arg1 / arg2);
            }

            return ("" + arg1 / arg2);



        }
    }, SUB ("vichitanie") {
        @Override
        public String OperCalc(int arg1, int arg2) {
            return ( ""+ (arg1 - arg2));
        }
    }, MUL("umnozhenie") {
        @Override
        public String OperCalc(int arg1, int arg2) {
            return (""+ arg1*arg2);
        }
    };
    final String description;

    OperationCalc(String desc){
        this.description=desc;
    }

    public  abstract String OperCalc(int arg1, int arg2);



}
