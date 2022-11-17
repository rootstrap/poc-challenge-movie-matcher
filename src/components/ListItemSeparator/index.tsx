import React from 'react';
import { ViewProps } from 'react-native';

import View from 'components/View';

import styles from './styles';

type PropTypes = ViewProps;

const ListItemSeparator: React.FunctionComponent<PropTypes> = ({ style, ...props }) => {
  return <View style={[styles.separator, style]} {...props} />;
};

export default ListItemSeparator;
