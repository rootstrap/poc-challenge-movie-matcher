import { StyleSheet } from 'react-native';

import { GREEN, WHITE } from 'constants/colors';

export default (color: string, isInverted: boolean, isSelected: boolean) => {
  const colorButton = isSelected ? GREEN : color;

  return StyleSheet.create({
    container: {
      alignItems: 'center',
      borderColor: colorButton,
      borderRadius: 4,
      borderWidth: 1,
      backgroundColor: isInverted ? WHITE : colorButton,
      paddingVertical: 8,
    },
    label: {
      color: isInverted ? colorButton : WHITE,
      fontSize: 10,
      fontWeight: '700',
    },
  });
};
