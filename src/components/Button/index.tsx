import React from 'react';
import { Text, TouchableOpacity } from 'react-native';

import { PRIMARY_COLOR } from 'constants/colors';

import getStyles from './styles';

type PropTypes = {
  label: string;
  style: object;
  handleOnPress: () => void;
  color?: string;
  isInverted?: boolean;
  isSelected: boolean;
};

const Button: React.FunctionComponent<PropTypes> = ({
  label,
  style,
  handleOnPress,
  color = PRIMARY_COLOR,
  isInverted = false,
  isSelected,
}) => {
  const styles = getStyles(color, isInverted, isSelected);

  return (
    <TouchableOpacity style={[styles.container, style]} onPress={handleOnPress}>
      <Text style={styles.label}>{label}</Text>
    </TouchableOpacity>
  );
};

export default Button;
