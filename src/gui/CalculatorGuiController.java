package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.ScrollEvent;

/**This class is for the gui and calculation.
 * 
 * */
public class CalculatorGuiController {

    @FXML
    private ComboBox<?> skill_comboBoxCharacter;

    @FXML
    private Button skill_buttonReset;

    @FXML
    private ComboBox<?> skill_comboBoxSkill;

    @FXML
    private TextArea skill_textAreaSkillValue;

    @FXML
    private TextField skill_textFieldSkillMalus;

    @FXML
    private TextArea skill_textAreaAttribute1Name;

    @FXML
    private ComboBox<?> skill_comboBoxOverUnderAttribute1;

    @FXML
    private TextArea skill_textAreaAttribute1Value;

    @FXML
    private TextField skill_textFieldAttribute1Malus;

    @FXML
    private TextField skill_textFieldAttribute1Roll;

    @FXML
    private TextArea skill_textAreaAttribute2Name;

    @FXML
    private ComboBox<?> skill_comboBoxOverUnderAttribute2;

    @FXML
    private TextArea skill_textAreaAttribute2Value;

    @FXML
    private TextField skill_textFieldAttribute2Malus;

    @FXML
    private TextField skill_textFieldAttribute2Roll;

    @FXML
    private TextArea skill_textAreaAttribute3Name;

    @FXML
    private ComboBox<?> skill_comboBoxOverUnderAttribute3;

    @FXML
    private TextArea skill_textAreaAttribute3Value;

    @FXML
    private TextField skill_textFieldAttribute3Malus;

    @FXML
    private TextField skill_textFieldAttribute3Roll;

    @FXML
    private TextField skill_textFieldDiceSize;

    @FXML
    private TextArea skill_textAreaLog;

    @FXML
    void skill_buttonCalculate(ActionEvent event) {

    }

    @FXML
    void skill_buttonRandomRolls(ActionEvent event) {

    }

    @FXML
    void skill_checkBoxNpc(ActionEvent event) {

    }

    @FXML
    void skill_scrollBarLog(ScrollEvent event) {

    }

}
