package devproblem.exception;

public  enum ErrorCode {
    FILE_LOAD_OR_ACCESS_ERRO("WI-00001");

    public final String label;

    private ErrorCode(String label) {
        this.label = label;
    }
}
