import React, { ReactNode } from 'react';
import { StyleProp, ViewStyle } from 'react-native';
import { Card as RNPCard } from 'react-native-paper';

import View from 'components/View';

import { Movie } from 'types/index';

import styles from './styles';

interface PropTypes {
  children?: ReactNode;
  style?: StyleProp<ViewStyle>;
  contentStyle?: StyleProp<ViewStyle>;
  onPress?: () => void;
  onLongPress?: () => void;
}
const Card: React.FunctionComponent<PropTypes> = ({
  children,
  style,
  contentStyle,
  onPress,
  onLongPress,
  ...props
}) => (
  <RNPCard {...props} style={[styles.card, style]} onPress={onPress} onLongPress={onLongPress}>
    <View style={[styles.content, contentStyle]}>{children}</View>
  </RNPCard>
);

export default Card;
