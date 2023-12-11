package CarGUI;
//
public interface CarViewObserver {
    void onGasButtonPressed(int amount);
    void onBreakButtonPressed(int amount);
    void onStartEngineButtonPressed();
    void onStopEngineButtonPressed();
    void onTurnLeftButtonPressed();
    void onTurnRightButtonPressed();
    void onSetTurboOnButtonPressed();
    void onSetTurboOffButtonPressed();
    void onPlatformUpButtonPressed(double amount);
    void onPlatformDownButtonPressed(double amount);
    void onAddCarButtonPressed(String name);
    void onRemoveButtonPressed();
}
