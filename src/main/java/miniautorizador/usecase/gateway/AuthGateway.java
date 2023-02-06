package miniautorizador.usecase.gateway;

public interface AuthGateway {

    void saveTransaction();
    void listTransaction();
    void updateTransaction();
}
